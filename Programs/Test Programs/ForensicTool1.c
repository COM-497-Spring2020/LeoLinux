#include <stdio.h>
#include <stdlib.h>

int main()
{
	char value;

	printf("Totally a Forensic Tool!\n(Press 'e' + ENTER to exit)\n");
	value = getchar();

	if(value == 'e'){
		exit(0);
	}
	return 0;
}
