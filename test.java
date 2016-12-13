//asheq
import java.util.ArrayList;

public class test {

    public static void main(String args[]) {

        journal asheqsJournal = new journal();
        asheqsJournal.add(new task("buy groceries"));
        asheqsJournal.add(new task("clean room"));
        asheqsJournal.add(new task("wash car"));
        asheqsJournal.add(new task("general body meeting", taskType.CAL_));
        asheqsJournal.add(new task("eat dinner"));
        asheqsJournal.add(new task("final, december 13", taskType.CAL_));
        System.out.println(asheqsJournal);
        System.out.println();
        asheqsJournal.remove();
        System.out.println(asheqsJournal);
        System.out.println(asheqsJournal.getAllTaskIDs());

    }

}