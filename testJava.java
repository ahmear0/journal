import java.util.ArrayList;

public class testJava {

    public static void main(String args[]) {

        journal asheqsJournal = new journal();
        asheqsJournal.add(new task("buy groceries"));
        asheqsJournal.add(new task("clean room"));
        asheqsJournal.add(new task("wash car"));

        System.out.println(asheqsJournal);
        
    }

}