#include<stdio.h>

int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	
	int max = 0, index, val, temp, i;
	for(i = 0 ; i < n ; i++) {
		scanf("%d", &val);
		temp = val / m;
		if(val % m > 0)
			temp++;
		if(temp >= max) {
			max = temp;
			index = i+1;
		}
	}
	printf("%d", index);
	
	return 0;
}
