#x=[1,2,1,2,1,3]
#remove the duplicate element from the list 
x=[1,2,1,2,1,3]   # initialising the list

y=[]
for i in x:
    if i not in y:
      y.append(i)
                     #printing list 
      print(str(y))
