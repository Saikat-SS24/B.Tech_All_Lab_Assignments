#include<stdio.h>

char direction(char a, char b)
{
	if(a == 'N')
	{
		if(b == 'L')
			return 'W';
		else
			return 'E';
	}
	else if(a == 'W')
	{
		if(b == 'L')
			return 'S';
		else
			return 'N';
	}
	else if(a == 'S')
	{
		if(b == 'L')
			return 'E';
		else
			return 'W';
	}
	else if(a == 'E')
	{
		if(b == 'L')
			return 'N';
		else
			return 'S';
	}
}

int main()
{
	char s[10000],x='N';
	int i;
	scanf(" %s",s);
	for(i=0;s[i]!=0;i++)
	{
		x = direction(x,s[i]);
	}
	
	printf("\n\n final direction = %c",x);
	
	return 0;
}