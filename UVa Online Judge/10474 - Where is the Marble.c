/*
	Link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1415
*/

#include <stdlib.h>
#include <stdio.h>

int n;

int compfunc(const void *a,const void *b)
{
	return ( *(int*)a - *(int*)b );
}

int find(int N[], int x, int start, int end) {
	if(end >= start) {
		int i = (end + start) / 2;
		
		if((i == 0 || x > N[i-1]) && N[i] == x) {
			return i;
		} else if(x > N[i]) {
			return find(N, x, i+1, end);
		} else return find(N, x, start, i-1);
	}
	
	return -1;
}

int main()
{
	int a = 1;
	int q;
	
	do {
		scanf("%d %d", &n, &q);
		
		if(n != 0 || q != 0) {
		    int N[n];
		    int x, i;
		    
		    for(i = 0 ; i < n ; i++) {
		        scanf("%d", &N[i]);
		    }
		    
		    qsort(N, n, sizeof(*N), compfunc);
		    
		    printf("CASE# %d:\n", a);
		    
		    for(i = 0 ; i < q ; i++) {
		        scanf("%d", &x);
		        
		        int y = find(N, x, 0, n-1) + 1;
		        if(y != 0) {
		        	printf("%d found at %d\n", x, y);
				} else {
					printf("%d not found\n", x);
				}
		    }
		}
		
		a++;
	} while(n != 0 || q != 0);
	
    return 0;
}
