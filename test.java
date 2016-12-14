import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test {

	private static final String FILENAME = ".serverData";
	private static int portNumber = 4321;
	private static journal serverJournal;

	public static void main(String[] args) {

		serverJournal = new journal();
		//serverJournal.add(new task("buy groceries", taskType.TODO));
        //serverJournal.add(new task("clean room", taskType.TODO));
        //serverJournal.add(new task("wash car", taskType.TODO));
		System.out.println(serverJournal);
		loadServerData();
		System.out.println(serverJournal);
		writeServerData();
		System.out.println(serverJournal);

	}

	private static void loadServerData()
	{
		task tempTask;

		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				tempTask = serverJournal.parseTask(sCurrentLine);
				serverJournal.add(tempTask);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//write serverData to local file
	private static void writeServerData()
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

			task currentTask;
			int numTasks = serverJournal.getNumTasks();
			for (int i = 0; i < numTasks; i++)
				{
					currentTask = serverJournal.remove();
					bw.write(currentTask.toServer());
					bw.newLine();
				}
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//write serverData to socket
	private static void sendServerDataToSocket(PrintWriter outStream)
	{
        	task currentTask;
        	int numTasks = serverJournal.getNumTasks();
			for (int i = 0; i < numTasks; i++)
				{
					currentTask = serverJournal.remove();
					outStream.println(currentTask.toServer());
				}
	}

}