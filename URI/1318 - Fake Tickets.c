#include <stdio.h>

int
main()
{
	int N, M;

	do {

		scanf("%d %d", &N, &M);

		int i, j, count, check, T[M];

		for(i = 0 ; i < M ; i++) {
			scanf("%d", &T[i]);
		}

		for(i = 1, count = 0 ; i <= N ; i++) {
			for(j = 0, check = M ; j < M ; j++) {
				if(i == T[j]) {
					check--;
				}
			}

			if(check < M - 1)
				count++;
		}

		if(N >= 1 && N <= 10000 && M >= 1 && M <= 10000)
			printf("%d\n", count);

	} while(N >= 1 && N <= 10000 && M >= 1 && M <= 10000);

	return 0;

}

