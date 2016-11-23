all:
	gcc -pthread -o main main.c -Wall -g
	gcc -o fs fileSystem.c
	g++ -o hello hello.cpp
