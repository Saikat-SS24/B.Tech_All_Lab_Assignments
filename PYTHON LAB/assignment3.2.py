#Write a python script to sort (ascending and descending) a dictionary by value
#input := {0:0  ,1:2, 2:1 , 3:4 , 4:3}
#output := [(0,0), (2,1), (1,2) (4,3),(3,4)]
# [(3,4) ,(4,3),(1,2),(2,1),(0,0)]
import operator
d = {0: 0, 1: 2, 2: 1, 3: 4, 4: 3}
sorted_d = sorted(d.items(), key=operator.itemgetter(1))
print(sorted_d)
sorted_d = sorted(d.items(), key=operator.itemgetter(1),reverse=True)
print(sorted_d)