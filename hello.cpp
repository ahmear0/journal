#include <iostream>
#include <string>

using namespace std;

class task
{
    private:
        int taskId;
        string taskData;

    public:
       
       void newTask(int _taskId, string _taskData)
       {
          taskId = _taskId;
          cout << "Task " << taskId << " created.";
          taskData = _taskData;
        }

       int modifyData(char* _newTaskData)
       {
          if (taskId == 0)
          {
            return 0;
          }
          else
          {
            taskData = _newTaskData;
            return 1;
          }
        }

        string getData()
        {
          return taskData;
        }

        int getId()
        {
          return taskId;
        }
};

 int main()
 {
      task *t1 = new task;
      t1->newTask(999,"this is the task data");
      string *data = new string;
      data->(t1->getData());
      cout << data << "\n";

      return 0;
 }

 class todo extends task
 {
    public:

    private:
      
 }