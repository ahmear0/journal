##Journal Client
####Asheq Ahmed ara47
######1. Project description:Journal that maintains to-do list items, calendar events and personal notesWritten in java to make use of classes and objects because that’s so much easier in java than to make an object equivalent with C++ (which i don't really know) or with C	* Client.java (main method to testrun the journal.  Has it’s own instance of a Journal that it updates with tasks when users enter them)	* Server.java (takes in taskid’s from the socket and checks if it needs to update it’s version of the journal.  If it needs to update anything, it sends back the taskid’s of the tasks it needs to the socket for the client to respond with.  Then, it takes in task data to update tasks)	* Task.java (implements a task object that contains taskid, content and taskType.  taskType is a enum of todo, notes, calendar entry)	* Journal.java (implements a queue of tasks using java ArrayList because it was quick and I don’t feel like writing an implementation of a real queue by extending Java.util.Queue)	* TaskType.java (enum used in task.java)	######2. Files included in .zip######3. Data structures include:	* Queue implementation of tasks using ArrayList	* A Journal is a Queue of Tasks, implemented using ArrayList	  journal, however, is not an extension of Queue, because I honestly didn’t want to	* Socket to share journal data, but this is a java posix socket######4. DemoExtract **ara47_final.zip**open the directory in a linux shell
Use the `make` command to compile the project.to begin, enter `java test <port>` 

possible commands include: `display`, `add`, `remove`, `remove <taskid>`, `removeAll`, `populate`, `help`, `sync` & `exit`.

enter `populate` to add example content to the Journal

enter `display`

![demo1](a2.jpg "example1")

enter `removeAll` to clear all contents

enter `remove` to remove only the first task

enter `display` to find a task to remove, then enter `remove <taskid>` to select a particular task

######4.1 Demo with both Client and Server Instances

This part can be easier to explain in a quicktime video
Unfortunately it is several MB's large, so I made it a public file accessible here:

https://drive.google.com/file/d/0B1aQmfAJoRq8dmtrck5zWEdEQnM/view

Alternatively, you can find it on youtube:
https://youtu.be/He0i9tYZEUw

