#Write a python function called compare which takes two strings s1 and s2  and an integer n as arguments.
#The function should return True if first n characters of both the strings are same else the function should return False
#Input  =
#First string=Programming
#Second string=Program
#Enter a number=4
#Output=True
#input=
#First string=Techno India College Of Technology
#Second string=Techno International New Town
#Enter a number=5
#Output=True
#input=
#First string=Programming is easy
#Second string=Python programming is easy
#Enter a number=4
#Output=False
def check(s1,s2,n):
    if(s1[0:n]==s2[0:n]):
        print("True")
    else:
        print("False")
check("Programming","Program",4)