import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Integer;

public class KnockKnockServer {

    private static final int PORTNUMBER = 4321;
    private static final int TASKIDLENGTH = 4;

    public static void main(String[] args) throws IOException {

        String a1 = "4921";
        String a2 = "0921";
        String a3 = "4921a";
        String a4 = "49ae";

        System.out.println(isValidID(a1) + ", " + isValidID(a2) + ", " + isValidID(a3) + ", " + isValidID(a4));

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
                parseTasks(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + PORTNUMBER + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<task> parseTasks(String toBeParsed)
    {
        ArrayList<task> tasks = new ArrayList<task>();
        String parsedString;
        while (toBeParsed.equals("") != true && toBeParsed != null)
        {
            parsedString = toBeParsed.substring(0,4);
            System.out.println(parsedString);

        }
        return tasks;
    }

    private static boolean isValidID(String _id)
    {
        if (_id.length() == 4)
        {
                if (_id.matches("^[1-9][0-9][0-9][0-9]$"))
                {
                    return true;
                }
        }
        return false;
    }
}








