#Write a  python program to get a string from a given string where all occurrences of its first character have been changed to ‘$’
#except the first char itself
#Input := onion
#Output := oni$n
def change_char(str1):
  char = str1[0]
  str1 = str1.replace(char, '$')
  str1 = char + str1[1:]

  return str1

str = input()
print(change_char(str))