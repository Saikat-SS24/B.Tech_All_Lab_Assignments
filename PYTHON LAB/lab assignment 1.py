x=[1,2,3],[4,5,6,7],[5,6,4,3]
y=[]
sum=0
for i in range(len(x)):
    for j in range(len(x[i])):
        sum=sum+x[i][j]
    y.append(sum)
    sum=0
print(y)
