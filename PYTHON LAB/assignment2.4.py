#Find unique elements (which are not repeated) in matrix of size N x M. Use tuple only to store the input.
#Input: First line containing two space separated integers N and M representing number of row and column respectively.
#Next N lines are the matrix rows. Each row having M space separated integers.
#Output: unique elements in a line. Print "No" if no such elements found.
x, y = map(int, input().split())                    #taking rows and columns
dataTemp = []
for i in range(x):                                  #taking list of input
    temp = list(map(int, input().split()))          
    for item in temp:
        dataTemp.append(item)
data = tuple(dataTemp)                              #converting list to tuple 
res = []
for item in data:                   
    if data.count(item) == 1:                       #checking for unique element
        res.append(item)                            #adding to result if unique
if len(res) == 0:                                   #printing no if result empty
    print('NO') 
else:
    for item in res:                                #printing the unique elements
        print(item, end = ' ')