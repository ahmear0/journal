all:
	gcc -pthread -o main main.c -Wall -g
	gcc -o fs fileSystem.c
	javac taskType.java
	javac testJava.java
	javac task.java
	javac journal.java
