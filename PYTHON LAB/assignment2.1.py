#input:The first line is an integer representing N. The 2nd line contains N space separated integer
#output:Lines with two integer. The first one is the number with highest frequency and the second one is the frequency.
x = int(input())                                #taking length of input
data = tuple(map(int, input().split()))         #taking data input
dataDup = list(set(data))                       #list without duplicate numbers
freq = [data.count(item) for item in dataDup]   #frequency calculated list 
maxFreq = max(freq)                             #maximum frequency
for i in range(len(freq)-1, -1, -1):            
    if freq[i] == maxFreq:
        print(dataDup[i], freq[i])              #printing result