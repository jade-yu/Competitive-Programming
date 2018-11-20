#include <stdlib.h>
#include <stdio.h>

int compfunc(const void *a,const void *b)
{
	return ( *(int*)a - *(int*)b );
}

int main()
{
    int n, m, i, j, count = 0;
    scanf("%d %d", &n, &m);

    int N[n], M[m];
    for(i = 0 ; i < n ; i++) {
        scanf("%d", &N[i]);
    }
    for(i = 0 ; i < m ; i++) {
        scanf("%d", &M[i]);
    }
    qsort(N, n, sizeof(*N), compfunc);
    qsort(M, m, sizeof(*N), compfunc);

    int *R;
    R = (int *) malloc(1);
    i = 0, j = 0;
    
    while(i < n && j < m) {
        if(N[i] == M[j]) {
            count++;
            R = (int *) realloc(R, count);
            R[count-1] = N[i];
            i++;
            j++;
        } else if(N[i] < M[j]) {
            i++;
        } else {
            j++;
        }
    }

	if(count == 0) {
        printf("NO INTERSECTIONS");
	} else {
	    for(i = 0 ; i < count ; i++) {
	        printf("%d ", R[i]);
	    }
	}
	
    free(R);
    return 0;
}
