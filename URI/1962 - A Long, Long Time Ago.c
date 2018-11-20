#include <stdio.h>
int
main()
{
	int N;
	scanf("%d", &N);
	int i, T[N];
	for(i = 0 ; i < N ; i++) {
		scanf("%d", &T[i]);
		if(T[i] > 2014)
			printf("%d A.C.\n", T[i] - 2014);
		else
			printf("%d D.C.\n", 2015 - T[i]); 
	}
	return 0;
}

