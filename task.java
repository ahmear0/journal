
public class task {

	int taskid;
	boolean status;
	String content;

	public task(){
		taskid = 0;
		status = true;
		content = "empty";
	}

	public task(String _content){
		taskid = (int) (Math.random()*8999+1000);
		status = true;
		content = _content;
	}

	public task(String _content, int _taskid){
		taskid = _taskid;
		status = true;
		content = _content;
	}

    public String toString() {

        return "taskid: " + taskid + ", " + content;
    }

}