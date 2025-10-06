#include <stdio.h>

void main() {
	int num;
	for (int vert = 1; vert <= 3; vert++) {
		//Nested Loops Gave Me Anxiety...
		num = vert;
		for (int horz = 1; horz <= 7; horz++) {
			printf("%d ", num);
			num += 2;
		}
		printf("\n");
	}
}
