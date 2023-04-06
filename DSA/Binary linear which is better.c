#include <stdio.h>

int a[]={-100,-89,-56, -5,0,6,10,75, 99};

int Linear_Search(int x){
	int count=0;
	 for(int i=0;i<9;i++){
	 	count++;
	 	if(a[i]==x){
			break;
	      	}
	}
	return count;
}  
int Binary_Search(int x){
	int start=0;
	int end=8;
	int mid;
	int count=0;
	while(start<=end){
		mid=(start+end)/2;
		if(a[mid]==x){
			count++;
			break;
		}
		else if(x<a[mid]){
			count++;
			end=mid-1;
		}
		else if(x>a[mid]){
			count++;
			start=mid+1;
		}
	}
	return count;
}
int main(){
	int c1,c2;
	c1=Linear_Search(-100);
	c2=Binary_Search(-100);
	printf("-100 %d %d\n",c1,c2);
	if(c1<c2){
		printf("Linear Search is better\n");
	}
	else{
		printf("Binary Search is better\n");
	}
	c1=Linear_Search(0);
	c2=Binary_Search(0);
	printf("0 %d %d\n",c1,c2);
	if(c1<c2){
		printf("Linear Search is better\n");
	}
	else{
		printf("Binary Search is better\n");
	}
	c1=Linear_Search(99);
	c2=Binary_Search(99);
	printf("99 %d %d\n",c1,c2);
	if(c1<c2){
		printf("Linear Search is better\n");
	}
	else{
		printf("Binary Search is better\n");
	}
	c1=Linear_Search(7);
	c2=Binary_Search(7);
	printf("7 %d %d\n",c1,c2);
	if(c1<c2){
		printf("Linear Search is better\n");
	}
	else{
		printf("Binary Search is better\n");
	}
	return 0;
}