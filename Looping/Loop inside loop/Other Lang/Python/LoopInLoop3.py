def main():
	num = None
	for vert in range(1,4):
		num = vert
		# Nested Loops gave me anxiety, especially here...
		for horz in range(1,8):
			print(''.join([str(num), " "]), end="")
			num += 2
		print("");

main()
