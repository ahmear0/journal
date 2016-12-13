//asheq
public class task {

	int taskid;
	boolean status;
	String content;
	taskType _taskType;

	public task(){
		taskid = 0;
		status = true;
		content = "empty";
		_taskType = taskType.NOTE;
	}

	public task(String _content){
		taskid = (int) (Math.random()*8999+1000);
		status = true;
		content = _content;
		_taskType = taskType.NOTE;
	}

	public task(String _content, int _taskid){
		taskid = _taskid;
		status = true;
		content = _content;
		_taskType = taskType.NOTE;
	}

	public task(String _content, int _taskid, taskType type){
		taskid = _taskid;
		status = true;
		content = _content;
		_taskType = type;
	}

	public task(String _content, taskType type){
		taskid = (int) (Math.random()*8999+1000);
		status = true;
		content = _content;
		_taskType = type;
	}

	public int getTaskID()
	{
		return taskid;
	}

    public String toString() {

        return _taskType.name() + " taskid: " + taskid + ", " + content;
    }

    public String toServer() {
    	return "" + taskid + " " + _taskType.name() + " " + content;
    }

}