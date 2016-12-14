//asheq
import java.util.ArrayList;

public class journal {

	ArrayList<task> taskList;
	int numtasks;

	public journal(){
		taskList = new ArrayList<task>();
		numtasks = 0;
	}

	public int getNumTasks()
	{
		return numtasks;
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
		task removedTask = null;
		if (numtasks>0)
		{
			removedTask = taskList.get(0);
			taskList.remove(0);

			System.out.println("Removing taskid: " + removedTask.getTaskID());
			numtasks--;
		}
		return removedTask;
	}

	public int remove(int taskID)
	{

		int removeIndex = -1;
		int[] allTaskIDs = getAllTaskIDs();
		for (int i = 0; i < numtasks; i++)
		{
			if (allTaskIDs[i] == taskID)
			{
				removeIndex = i;
			}
		}

		if (removeIndex >= 0)
		{
			task taskToRemove = taskList.get(removeIndex);
			taskList.remove(removeIndex);

			System.out.println("Removing taskid: " + taskToRemove.getTaskID());
			numtasks--;
			return taskToRemove.getTaskID();
		}
		else
		{
			System.out.println("taskid " + taskID + " doesn't exist.");
		}
		return -1;
	}


	public void clear()
	{
		taskList = new ArrayList<task>();
		numtasks = 0;
	} 

	public int[] getAllTaskIDs()
	{
		
		int[] allTaskIDs = new int[numtasks];

		for (int i = 0; i < numtasks; i++)
    	{
    		allTaskIDs[i] = taskList.get(i).getTaskID();
    	}
        return allTaskIDs;
	}

	public String allTaskIDs_toString()
	{
		String taskIDsString = "";
		int[] taskIDs = getAllTaskIDs();
		for (int i = 0; i < taskIDs.length; i++)
		{
			taskIDsString += taskIDs[i];
			if (i<taskIDs.length-1)
			{
				taskIDsString += ", ";
			}
		}
		return taskIDsString;
	}

    public String toString() {

    	String taskString = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
    	
    	if (numtasks == 0)
    	{
    		taskString += "  [empty]\n";
    	}
    	for (int i = 0; i < numtasks; i++)
    	{
    		taskString += "+ " + taskList.get(i).toString();
			taskString += "\n";
    	}


    	taskString += "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
        return taskString;
    }

    public static task parseTask(String toBeParsed)
    {
        task _task = null;
        String parsedString, _content;
        int _validID;
        taskType _taskType;

        parsedString = toBeParsed.substring(0,4);
        if (isValidID(parsedString))
        {
            _validID = Integer.parseInt(parsedString);
            parsedString = toBeParsed.substring(5,9);

            _taskType = taskType.valueOf(parsedString);
            _content = toBeParsed.substring(10, toBeParsed.length());

            _task = new task(_content, _validID, _taskType);
        }
            
        return _task;
    }

    public static boolean isValidID(String _id)
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