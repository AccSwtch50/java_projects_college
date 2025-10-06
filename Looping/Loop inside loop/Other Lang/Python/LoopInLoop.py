def main():
	for vert in range(0,3):
		# Nested Loops gave me anxiety, especially here...
		for horz in range(0,8):
			print(''.join([str(vert), " "]), end="");
		print("");

main()
