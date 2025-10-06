#include <stdio.h>

void main() {
	int prev_num3 = 0;
	int prev_num2 = 0;
	int prev_num1 = 1;
	int number = 0;
	printf("%d ", prev_num3);
	printf("%d ", prev_num2);
	printf("%d ", prev_num1);
	for (int i=0; i < 7; i++) {
		number = prev_num3 + prev_num2 + prev_num1;
		prev_num3 = prev_num2;
		prev_num2 = prev_num1;
		prev_num1 = number;
		printf("%d ", number);
	}
	printf("\n");
}
