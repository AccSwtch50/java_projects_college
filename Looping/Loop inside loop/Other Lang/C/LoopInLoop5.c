#include <stdio.h>

void main() {
	for (int vert = 1; vert <= 8; vert++) {
		//Nested Loops Gave Me Anxiety...
		for (int horz = vert; horz <= 8; horz++) {
			printf("%d ", horz);
		}
		printf("\n");
	}
}
