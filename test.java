import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test {

	private static final String FILENAME = ".serverData";
	private static journal serverJournal;

	public static void main(String[] args) {

		serverJournal = new journal();
		
		loadServerData();
		writeServerData();

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

	private static void writeServerData()
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

			String lineToWrite;

			for (int i = 0; i < serverJournal.getNumTasks(); i++) {
				bw.write("something");
				bw.newLine();
			}
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}