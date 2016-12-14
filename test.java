//asheq
import java.util.ArrayList;
import java.io.*;
import java.lang.Integer;
import java.lang.IllegalArgumentException;

public class test {

    static boolean running;
    static journal j;

    public static void main(String args[]) {
        running = true;
        String userInput, userArgument = null;
        String[] userInputArguments;
        journal j = new journal();
        System.out.print(">please make a selection [display, add, remove, removeAll, populate, help, exit]\n");
        try 
            (
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
                    System.out.print(">please make a selection [display, add, remove, removeAll, populate, exit]\n");
                }

                //add
                else if (userInput.equals("add"))
                {
                    System.out.println("Enter task content:");
                    userInput = stdin.readLine();
                    String _content = userInput;

                    System.out.println("Enter task type [TODO, NOTE, CAL_]:");
                    userInput = stdin.readLine();
                    try {
                        taskType _taskType = taskType.valueOf(userInput);

                        j.add(new task(_content, _taskType));
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
                }

                //display
                else if (userInput.equals("display"))
                {
                    System.out.println(j);
                }

                else if (userInput.equals("populate"))
                {
                    j.add(new task("buy groceries", taskType.TODO));
                    j.add(new task("clean room", taskType.TODO));
                    j.add(new task("wash car", taskType.TODO));
                    j.add(new task("gb meeting 12/7/16", taskType.CAL_));
                    j.add(new task("locker combo is 10-20-30", taskType.NOTE));
                    j.add(new task("eecs 338 project due, 12/13/16", taskType.CAL_));
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

    // class journalThread extends Thread {

    // journalThread() {
    // }
    // journalThread(String threadName) {
    //     super(threadName); // Initialize thread.
    //     System.out.println(this);
    //     start();
    // }
    // public void run() {
    //     //Display info about this particular thread
    //     System.out.println(Thread.currentThread().getName());
    // }
}
}