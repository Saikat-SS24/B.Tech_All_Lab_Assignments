#Write a python program to count the occurrences of each word in a given sentences
#Input = learning python is fun and python is powerful
#Output=
#powerful=1
#python=2
#fun=1
#and=1
#is=2
#learning=1
a="learning python is fun and python is powerful"
p=a.split()
z=["powerful","python","fun","and","is","learning"]
for i in z:
    print(i,"=",p.count(i))

