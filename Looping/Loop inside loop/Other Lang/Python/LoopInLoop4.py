def main():
	for vert in range(1,4):
		# Nested Loops gave me anxiety, especially here...
		for horz in range(1,4):
			print(''.join([str(vert), " x ", str(horz), " = ", str(vert * horz)]))
		print("");

main()
