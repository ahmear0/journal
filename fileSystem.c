#include <stdio.h>
#include <stdlib.h>
#include <string.h>

main() {
	FILE *fp;
	int status;

	fp = fopen("test.c", "w+");
	fprintf(fp, "#include <stdio.h>\n\n main() {printf(\"hello\\n\");}\n\n");
	//fputs("This is testing for fputs...\n", fp);
	fclose(fp);

	status = system("gcc -o test test.c");
	printf("gcc -o test test.c");
	status = system("cat test.c");
	status = system("rm test.c");

	status = system("./test");
	printf("./test");
}