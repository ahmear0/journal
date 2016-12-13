//asheq
import java.util.ArrayList;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.io.*;

public class test {

    static boolean running;

    public static void main(String args[]) {
        running = true;
        String userInput;
        journal j = new journal();

        do {
            System.out.print(">");

            System.out.print("please make a selection [display, add, remove <taskid>, removeAll, exit]");
            
            try 
            (
                BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));    
            )
            {
                userInput = stdIn.readLine();
                j.add(new task("buy groceries"));
                j.add(new task("clean room"));
                j.add(new task("wash car"));
                j.add(new task("general body meeting", taskType.CAL_));
                j.add(new task("eat dinner"));
                j.add(new task("final, december 13", taskType.CAL_));
                System.out.println(j);
                System.out.println();
                j.remove();
                
                j.remove(3415);
                System.out.println(j);
                System.out.println(j.allTaskIDs_toString());

                running = false;

            } catch (IOException e) {
            System.err.println("IOException thrown using BufferedREader");
        }
        } while (running);

    }

}