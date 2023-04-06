#Write a python function that print out the first n rows of the  pascal’s  triangle . import the module and accept n from the user.
#Input = 7
#[1]
#[1, 1]
#[1, 2, 1]
#[1, 3 ,3, 1]
#[1, 4, 6, 4, 1]
#[1, 5, 10, 10,5, 1]
#[1, 6, 15, 20,1 5,6,1]
def pascal_triangle(n):
   trow = [1]
   y = [0]
   for x in range(max(n,0)):
      print(trow)
      trow=[l+r for l,r in zip(trow+y, y+trow)]
   return n>=1
t=int(input())
pascal_triangle(t)