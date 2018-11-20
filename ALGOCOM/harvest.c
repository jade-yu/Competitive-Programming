#include <stdio.h>

int main() {
	int n, m, i, x, t = 0;
	scanf("%d %d", &n, &m);
	
	for(i = 0 ; i < n ; i++) {
		scanf("%d", &x);
		t += x;
	}
	
	if(t < n*m) {
		printf("NOT ENOUGH FOOD");
	} else if(t == n*m) {
		printf("JUST ENOUGH FOR EVERYONE");
	} else {
		printf("PARTY!");
	}
}

