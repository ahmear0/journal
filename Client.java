//asheq
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.IllegalArgumentException;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Client {

    private static final String HOST = "127.0.0.1";
    //private static final int PORTNUMBER = 4321;

    static boolean running, serverSync;
    static journal j;
    static final String helpString = ">please make a selection [display, add, remove, remove <id>, removeAll, populate, help, load, sync, exit]";

    public static void main(String args[]) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java Client <port>");
            System.exit(1);
        }
 
        int PORTNUMBER = Integer.parseInt(args[0]);

        running = true;
        serverSync = true;
        String userInput, socketText, userArgument = null;
        String[] userInputArguments;
        journal j = new journal();
        System.out.println(helpString);

        try 
            (
                Socket socket = new Socket(HOST, PORTNUMBER);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
                BufferedReader stdin =
                    new BufferedReader(new InputStreamReader(System.in));    
            )
            {
            do {
            
                System.out.print(">");
                userInput = stdin.readLine();
                userInputArguments = userInput.split(" ");
                if (userInputArguments.length>1)
                {
                    userInput = userInputArguments[0];
                    userArgument = userInputArguments[1];
                }

                if (userInput.equals("help"))
                {
                    System.out.println(helpString);
                }

                else if (userInput.equals("sync"))
                {
                    if (serverSync)
                    {
                        serverSync = false;
                        System.out.println("Client will no longer write changes to Socket.");
                    }
                    else
                    {
                        serverSync = true;
                        System.out.println("Client will write changes to Socket.");
                    }
                    
                }

                else if (userInput.equals("load"))
                {
                    task tempTask;

                    String sCurrentLine;

                    while ((sCurrentLine = in.readLine()) != null) {
                        System.out.println(sCurrentLine);
                        tempTask = j.parseTask(sCurrentLine);
                        j.add(tempTask);

                    }
                    System.out.println("GOT HERE");
                }

                //add
                else if (userInput.equals("add"))
                {
                    System.out.println("Enter task content:");
                    System.out.print("add >");
                    userInput = stdin.readLine();
                    String _content = userInput;

                    System.out.println("Enter task type [TODO, NOTE, CAL_]:");
                    System.out.print("add >");
                    userInput = stdin.readLine();
                    try {
                        taskType _taskType = taskType.valueOf(userInput);

                        task _newTask = new task(_content, _taskType);
                        j.add(_newTask);

                        if (serverSync)
                        {
                            out.println(_newTask.toServer());
                        }

                    }catch (IllegalArgumentException e) 
                    {
                        System.out.println("Usage: <taskType>");
                    }

                }

                //remove
                else if (userInput.equals("remove"))
                {
                    if (userArgument!=null && j.isValidID(userArgument))
                    {
                        int taskid = Integer.parseInt(userArgument);
                        j.remove(taskid);
                    }
                    else if (userArgument ==null)
                    {
                        j.remove();
                        if (serverSync)
                        {
                            out.println("-");
                        }
                    }
                    else
                    {
                        System.out.println("Usage: remove <taskid>");
                    }
                    userArgument = null;
                }

                //removeAll
                else if (userInput.equals("removeAll"))
                {
                    j.clear();
                    if (serverSync)
                    {
                        out.println("--");
                    }
                }

                //display
                else if (userInput.equals("display"))
                {
                    System.out.println(j);
                }

                else if (userInput.equals("populate"))
                {
                    if (serverSync)
                    {
                        out.println("pull");
                    }
                    
                    // j.add(new task("buy groceries", taskType.TODO));
                    // j.add(new task("clean room", taskType.TODO));
                    // j.add(new task("wash car", taskType.TODO));
                    // j.add(new task("gb meeting 12/7/16", taskType.CAL_));
                    // j.add(new task("locker combo is 10-20-30", taskType.NOTE));
                    // j.add(new task("eecs 338 project due, 12/13/16", taskType.CAL_));
                }

                else if (userInput.equals("exit"))
                {
                    running = false;
                }
            } while (running);

            } catch (IOException e) 
            {
                e.printStackTrace();
                System.exit(1);
            }         
    }
}