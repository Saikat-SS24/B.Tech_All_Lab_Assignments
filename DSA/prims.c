#include<stdio.h>
#include<stdlib.h>

#define MAX 999

int cost[10][10];
int visited[10];
int d[10];
int parent[10];
int i,j,count = 0,v,u,n,min;

int main()
{
   printf("Enter the matrix of vertex: \n");
   scanf("%d", &n);
   printf("Enter the cost matrix: \n");
   for(i = 0; i < n ; i++)
   {
     for(j = 0; j < n; j++)
     {
       scanf("%d", &cost[i][j]);
       if(cost[i][j] == 0)
         cost[i][j] = MAX;
     }
   }
   prims();
   return 0;
}
void prims()
{
	for(i = 0; i < n; i++)
	{
		visited[i] = 0;
		d[i] = MAX;
		parent[i] = -1;
	}
	d[0] = 0;
	parent[0] = -1;
	count = 1;
	while(count <= n-1)
	{
		min = MAX;
		for(i = 0; i < n; i++)
		{
			if(visited[i] == 0 && d[i] < min)
			{
				min = d[i];
				u = i;
			}
		}
		visited[u] = 1;
		for(v = 0; v < n; v++)
		{
			if(cost[u][v] != MAX && visited[v] == 0 && cost[u][v] < d[v])
			{
				parent[v] = u;
				d[v] = cost[u][v];
			}
		}
		count++;
	}
	print();
}
void print()
{
	int value = 0;
	printf("\nEdge\tCost");
	for(i = 0; i < n; i++)
	{
		printf("\n%d => %d %d", parent[i], i, cost[i][parent[i]]);
		value += cost[i][parent[i]];
	}
	printf("\nTotal cost: %d\n", value);
}




