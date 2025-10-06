#include <stdio.h>

void main() {
	for (int vert = 1; vert <= 3; vert++) {
		//Nested Loops Gave Me Anxiety...
		for (int horz = 0; horz < 8; horz++) {
			printf("%d ", vert);
		}
		printf("\n");
	}
}
