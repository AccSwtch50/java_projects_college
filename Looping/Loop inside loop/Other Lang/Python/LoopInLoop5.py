def main():
	for vert in range(1,9):
		# Nested Loops gave me anxiety, especially here...
		for horz in range(vert,9):
			print(''.join([str(horz), " "]), end="")
		print("");

main()
