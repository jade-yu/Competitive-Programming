/*
	Link: https://open.kattis.com/problems/quadrant
*/

#include <stdio.h>

int main() {
	int x,y,q = 1;
	scanf("%d %d", &x, &y);
	if(x>0) {
		if(y<0){
			q=4;
		}
	} else {
		if(y<0){
			q=3;
		} else q=2;
	}
	printf("%d", q);
}

