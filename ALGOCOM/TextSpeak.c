#include <stdio.h>

int main() {
	char x;
	scanf("%c", &x);
	printf("%c", x);
	
	char y = x;
	
	while(scanf("%c", &x) != EOF) {
		switch(x) {
			case ' ':
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				break;
			default:
				if(x != y) {
					printf("%c", x);
					y = x;
				}
				break;
		}
	}
	
	return 0;
}

