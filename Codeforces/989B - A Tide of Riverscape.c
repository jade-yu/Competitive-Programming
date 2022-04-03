//Link to problem: https://codeforces.com/problemset/problem/989/B

#include <stdio.h>

int main()
{
    int n, p;
    scanf("%d %d", &n, &p);
    
    char N[n];
    scanf("%s", N);
    
    int i = 0, flag = 0;
	
	while(flag == 0 && i + p < n) {
		if(N[i] == '.') {
			flag = 1;
			if(N[i+p] == '.') {
				N[i] = '1';
			} else {
					N[i] = '1';
				else N[i] = '0';
			}
		} else {
			if(N[i+p] == '.') {
				flag = 1;
				if(N[i] == '0')
					N[i+p] = '1';
				else N[i+p] = '0';
			} else if(N[i] != N[i+p]) {
				flag = 1;
			}
		}
		
		i++;
	}
	
	if(flag == 1) {
		i = 0;
		
		while(i < n) {
			if(N[i] == '.') {
				N[i] = '0';
			}
			
			i++;
		}
		printf("%s", N);
	} else printf("No");
	
    return 0;
}

