#include <stdlib.h>
#include <stdio.h>

int compfunc(const void *a,const void *b)
{
	return ( *(int*)a - *(int*)b );
}

int main()
{
    int n, x, i;
    scanf("%d", &n);

    int N[n];
    for(i = 0 ; i < n ; i++) {
        scanf("%d", &N[i]);
    }
    qsort(N, n, sizeof(*N), compfunc);
    
    scanf("%d", &x);

	printf("%d", N[x-1]);
	
    return 0;
}
