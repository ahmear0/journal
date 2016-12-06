//asheq
import java.util.ArrayList;

public class journal {

	ArrayList<task> taskList;
	int numtasks;

	public journal(){
		taskList = new ArrayList<task>();
		numtasks = 0;
	}

	public boolean add(task _task)
	{
		taskList.add(_task);
		numtasks++;
		return true;
	}

	//remove first item
	public task remove()
	{
		task taskToRemove = taskList.get(0);
		taskList.remove(0);

		System.out.println("Removing taskid: " + taskToRemove.getTaskID());
		numtasks--;
		return taskList.get(0);
	}

	public void clear()
	{
		numtasks = 0;
	} 

	public String getAllTaskIDs()
	{
		String allTasks = "";
		for (int i = 0; i < numtasks; i++)
    	{
    		allTasks += taskList.get(i).getTaskID();
    		if (i!=numtasks-1)
    		{
    			allTasks += ", ";
    		}
    	}
        return allTasks;
	}

    public String toString() {

    	String taskString = "";
    	for (int i = 0; i < numtasks; i++)
    	{
    		taskString += taskList.get(i).toString();
    		if (i!=numtasks-1)
    		{
    			taskString += "\n";
    		}
    	}
        return taskString;
    }

}