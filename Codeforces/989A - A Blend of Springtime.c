//Link to problem: https://codeforces.com/problemset/problem/989/A

#include <stdio.h>

int main()
{
    char n[100];
    scanf("%s", n);
    
    int i = 1, flag = 0;
	
	while(flag == 0 && n[i] != '\0' && i < 99) {
		if(n[i+1] != '\0') {
			switch(n[i]) {
				case 'A':
					if(n[i-1] == 'B' && n[i+1] == 'C' || n[i-1] == 'C' && n[i+1] == 'B')
						flag = 1;
					break;
				case 'B':
					if(n[i-1] == 'A' && n[i+1] == 'C' || n[i-1] == 'C' && n[i+1] == 'A')
						flag = 1;
					break;
				case 'C':
					if(n[i-1] == 'A' && n[i+1] == 'B' || n[i-1] == 'B' && n[i+1] == 'A')
						flag = 1;
					break;
			}
		}
		
		i++;
	}
	
	if(flag == 1) {
		printf("Yes");
	} else printf("No");
	
    return 0;
}

