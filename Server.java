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

    static journal serverj;
    static boolean running;
    private static final String FILENAME = ".serverData";

    public static void main(String[] args) throws IOException {
        // fw = new FileWriter(FILENAME);

        //BufferedReader bw = new BufferedReader(fw);
        //bw.readLine();


        serverj = new journal();
        running = true;

        if (args.length != 1) {
            System.err.println("Usage: java Server <port>");
            System.exit(1);
        }
 
        int PORTNUMBER = Integer.parseInt(args[0]);

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
            System.out.print("Server is running.");
            do 
            {
                System.out.println("Enter [read, display, exit]:");
                System.out.print("server >");
                userInput = stdin.readLine();
                if (userInput != null && userInput.equals("read"))
                {
                    System.out.println("Reading localhost" + PORTNUMBER + "...");
                    input = inStream.readLine();
                    try {
                        if (input.equals("-"))
                        {
                            serverj.remove();
                        }
                        else if (input.equals("--"))
                        {
                            serverj.clear();
                        }
                        else 
                        {
                            task newTask = serverj.parseTask(input);
                            serverj.add(newTask);
                        }
                    } catch (NullPointerException e)
                    {
                        System.out.println("Nothing to read.");
                    }
                }
                
                else if (userInput != null && userInput.equals("exit"))
                {
                    System.out.println("Bye.");
                    System.exit(1);
                }

                else if (userInput.equals("display"))
                {
                    System.out.println(serverj);
                }

            } while (running);

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + PORTNUMBER + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }
}