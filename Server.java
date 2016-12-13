import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Integer;

public class Server {

    private static final int PORTNUMBER = 4321;
    private static final int TASKIDLENGTH = 4;

    public static void main(String[] args) throws IOException {

        String a1 = "4921";
        String a2 = "0921";
        String a3 = "4921a";
        String a4 = "49ae";
        String b1 = "2341 NOTE this is a note";
        String b2 = "2342 CAL_ this is a note";

        System.out.println(journal.isValidID(a1) + ", " + journal.isValidID(a2));

        task task1 = journal.parseTask(b1);
        task task2 = journal.parseTask(b2);

        System.out.println(task1);
        System.out.println(task2);

        try ( 
            ServerSocket serverSocket = new ServerSocket(PORTNUMBER);

            Socket clientSocket = serverSocket.accept();

            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
         
            String inputLine = "5436 NOTE: hello this is a note";
            String outputLine = "The Server.java file wrote this";
            
            out.println(outputLine);
 
            while ((inputLine = in.readLine()) != null) {
                out.println(outputLine);
                journal.parseTask(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + PORTNUMBER + " or listening for a connection");
            System.out.println(e.getMessage());
        }



                // while (server_is_running)
        // {
        //     //Listen for any data
        //     //once data is given

        //     //parse out taskids
        //     int[] taskids;

        //     //check if taskid's are already in the journal

        //     //if some are absent from serverJournal, instantiate them using journal.add(new task("..."))
        //     if()
        //     {
        //         pthread_create(...);
        //     }
        //     //if some are missing, remove them
        //     if()
        //     {
        //         pthread_create(...);
        //     }
            
        // }
    }
}