#include <stdio.h>

void main() {
	for (int vert = 1; vert <= 4; vert++) {
		//Nested Loops Gave Me Anxiety...
		for (int horz = 1; horz <= 8; horz++) {
			printf("%d ", horz);
		}
		printf("\n");
	}
}
