#Write a python function to calculate the number of upper case letters and lower case letters in a string.
# Import the module to calculate the number of upper case letters and lower case  letters from a string input by the user.
s=input()
v=0
b=0
for c in s:
    if(c.isupper()):
        v=v+1
    if(c.islower()):
        b=b+1
    
print("UPPER CASE =",v)
print("LOWER CASE =",b)