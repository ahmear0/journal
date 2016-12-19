import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.lang.Integer;

public class Server {

    static journal serverJournal;
    static boolean running;
    private static final String FILENAME = ".serverData";
    private static int PORTNUMBER;

    public static void main(String[] args) throws IOException {

        serverJournal = new journal();
        running = true;

        if (args.length != 1) {
            System.err.println("Usage: java Server <port>");
            System.exit(1);
        }
 
        PORTNUMBER = Integer.parseInt(args[0]);

        try ( 
            ServerSocket serverSocket = new ServerSocket(PORTNUMBER);

            Socket clientSocket = serverSocket.accept();

            PrintWriter outStream =
                new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader inStream = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdin =
                    new BufferedReader(new InputStreamReader(System.in)); 
        ) {
            String userInput,input,output;
            System.out.println("Server is running.");
            loadServerData();

            do 
            {
                System.out.println("Enter [read, display, save, exit]:");
                System.out.print("server >");
                userInput = stdin.readLine();
                

                if (userInput != null && userInput.equals("read"))
                {
                    System.out.println("Accessing socket localhost : " + PORTNUMBER + "...");
                    input = inStream.readLine();
                    try {
                        if (input.equals("-"))
                        {
                            serverJournal.remove();
                        }
                        else if (input.equals("--"))
                        {
                            serverJournal.clear();
                        }
                        else if (input.equals("pull"))
                        {
                            sendServerDataToSocket(outStream);
                            outStream.close();
                        }
                        else 
                        {
                            task newTask = serverJournal.parseTask(input);
                            serverJournal.add(newTask);
                        }
                    } catch (NullPointerException e)
                    {
                        System.out.println("Nothing to read.");
                    }
                }
                
                else if (userInput != null && userInput.equals("save"))
                {
                    writeServerData();
                }

                else if (userInput != null && userInput.equals("load"))
                {
                    loadServerData();
                }

                else if (userInput != null && userInput.equals("exit"))
                {
                    System.out.println("Bye.");
                    System.exit(1);
                }

                else if (userInput.equals("display"))
                {
                    System.out.println(serverJournal);
                }

            } while (running);

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + PORTNUMBER + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }

    private static void loadServerData()
    {
        task tempTask;

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                tempTask = serverJournal.parseTask(sCurrentLine);
                serverJournal.add(tempTask);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //write serverData to local file
    private static void writeServerData()
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            task currentTask;
            int numTasks = serverJournal.getNumTasks();
            for (int i = 0; i < numTasks; i++)
                {
                    currentTask = serverJournal.remove();
                    bw.write(currentTask.toServer());
                    bw.newLine();
                }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //write serverData to socket
    private static void sendServerDataToSocket(PrintWriter outStream)
    {
            task currentTask;
            int numTasks = serverJournal.getNumTasks();
            for (int i = 0; i < numTasks; i++)
                {
                    currentTask = serverJournal.remove();
                    outStream.println(currentTask.toServer());
                }
    }
}