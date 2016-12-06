//asheq
import java.util.ArrayList;

public class testJava {

    public static void main(String args[]) {

        journal asheqsJournal = new journal();
        asheqsJournal.add(new task("buy groceries"));
        asheqsJournal.add(new task("clean room"));
        asheqsJournal.add(new task("wash car"));
        asheqsJournal.add(new task("general body meeting", taskType.CAL));
        asheqsJournal.add(new task("eat dinner"));
        asheqsJournal.add(new task("final, december 13", taskType.CAL));
        System.out.println(asheqsJournal);
        
    }

}