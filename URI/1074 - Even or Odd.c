#include <stdio.h>

int
main()
{

	int N;

	scanf("%d", &N);

	int i, X[N];

	for(i = 0 ; i < N ; i++) {
		scanf("%d", &X[i]);

		if(X[i] == 0)
			printf("NULL\n");
		else {
			if(X[i] % 2)
				printf("ODD ");
			else
				printf("EVEN ");
			if(X[i] > 0)
				printf("POSITIVE\n");
			else
				printf("NEGATIVE\n");
		}

	}

	return 0;
}

