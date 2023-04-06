#Find longest increasing sub-list(s) from a list.
#Input: Space separated integers in a line
#Output: One or multiple line containing first index and last index of the longest increasing sub-list in a line
l=[4, 6, 1, 2, 3, 4, 1, 2, 3]
count=0
m=0
si=0
li=0
fsi=0
fli=0
for i in range(len(l)-1):
    if l[i]<l[i+1]:
        count+=1
        li=i
    else:
        if m<count:
            fsi=si
            si=i+1
            fli=li+1
        m=count

print(fsi,fli)