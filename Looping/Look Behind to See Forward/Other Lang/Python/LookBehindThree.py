def main():
	prev_num3 = 0
	prev_num2 = 0
	prev_num1 = 1
	print(''.join([str(prev_num3), " "]), end="")
	print(''.join([str(prev_num2), " "]), end="")
	print(''.join([str(prev_num1), " "]), end="")
	for i in range (0,7):
		number = prev_num3 + prev_num2 + prev_num1
		prev_num3 = prev_num2
		prev_num2 = prev_num1
		prev_num1 = number
		print(''.join([str(number), " "]), end="")
	print("")

main()
