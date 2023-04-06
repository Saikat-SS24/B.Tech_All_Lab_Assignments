#A pair of numbers (a,b) is said to be amicable  if the sum of the proper divisors  of a is b and the sum of the proper divisors of b is
# Example 220 , 284 . Write a program that prints all four digit amicable pair between 1000 and 3000.
#output=
#1210            1184
#2924            2620
index1 = 1000
index2 = 3000
lst = []
amicables=[]
d = {}
for index in range(index1, index2+1):
    s = sum(i for i in range(1, index) if index % i == 0)
    d[index] = s
for n in d:
    if d[n] in d and d[d[n]] == n and n != d[n] and n not in amicables and d[n] not in amicables :
        amicables.append(n)
        amicables.append(d[n])
        print(d[n]," ",n)