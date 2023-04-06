 #Given a list of size N and an integer M. Find if there's a triplet in the array which sums up to the given integer M.
#Explanation: The triplet {1, 4, 8} in the array sums up to 13.
n = int(input())
m = int(input())

l = []*n

for i in range(n):           #taking input
    l[i] = int(input())

for i in range(n):
    for j in range((i+1),(n-1)):
        for k in range((j+1),(n-2)):
            if l[i]+l[j]+l[k] == m :       #checking condition
                print("Yes")
                quit()
    
print("No")
