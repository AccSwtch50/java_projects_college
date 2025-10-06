#include <stdio.h>

void main() {
	for (int vert = 1; vert <= 3; vert++) {
		//Nested Loops Gave Me Anxiety...
		for (int horz = 1; horz <= 3; horz++) {
			printf("%d x %d = %d\n", vert, horz, (vert * horz));
		}
		printf("\n");
	}
}
