#Input: N
#Output: a single integer representing the smallest N digit number whose sum of square of digits in a perfect square.
from math import sqrt
def isSquare(n):
	k = int(sqrt(n))
	return (k * k == n)

def calculate(pos, prev, sum, v):
	if (pos == len(v)):
		return isSquare(sum)
	for i in range(prev, 9 + 1):
		v[pos] = i
		sum += i * i
		if (calculate(pos + 1, i, sum, v)):
			return 1
		sum -= i * i
	return 0

def minValue(n):
	v = [0]*(n)
	if (calculate(0, 1, 0, v)):
		answer = ""
		for i in range(len(v)):
			answer += chr(v[i] + ord('0'))
		return answer
	else:
		return "-1"

print(minValue(2))