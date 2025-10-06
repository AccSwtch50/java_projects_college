def main():
	for vert in range(0,4):
		# Nested Loops gave me anxiety, especially here...
		for horz in range(1,9):
			print(''.join([str(horz), " "]), end="");
		print("");

main()
