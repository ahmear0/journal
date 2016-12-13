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