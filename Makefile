all:
	gcc -pthread -o main main.c -Wall -g
	javac taskType.java
	javac testJava.java
	javac task.java
	javac journal.java
	javac Frame.java
	javac Panel.java