import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Client {
	
	private static final String HOST = "127.0.0.1";
	private static final int PORTNUMBER = 4321;

    public static void main(String[] args) throws IOException {
 	
 
        try (
            Socket kkSocket = new Socket(HOST, PORTNUMBER);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
 
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;
                 
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + HOST);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                HOST);
            System.exit(1);
        }

        //this is the server's copy of the journal
        // clientJournal; = new journal();

        // while(user_is_using)
        // {
        //     //if user selects new task, 
        //     //make a new thread
        //     //take user input for task parameters
        //     if()
        //     {
        //         pthread_create(...);
        //     }
        //     //put this line in a runner//clientJournal.add(new task(...));

        //     //if user selects remove task
        //     else if()
        //     {
        //         pthread_create(...);
        //     }
        //     //put this line in a runner//clientJournal.remove(taskid);

        //     //user is done
        //     else if()
        //     {
        //         //break
        //     }
        // }

        // //open a connection to the socket using Java socket.
        // //127.0.0.1 4321

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
        // //handle exceptions and errors associated with sockets



    }
}
