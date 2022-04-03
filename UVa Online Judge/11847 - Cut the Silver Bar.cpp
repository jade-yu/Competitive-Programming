/*
	Link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2947

	Get the exponent of the nearest power of 2 less than or equal to n
*/
#include <cstdio>
#include <cmath>

using namespace std;

int getN(int n) {
	int i = 0, a = 1;
	while(a-1 < n) {
		a *= 2;
		i++;
	}
	return i-1;
}

int main() {
	int n;
	scanf("%d", &n);
	
	while(n != 0) {
		printf("%d\n", getN(n));
		scanf("%d", &n);
	}
	
	return 0;
}
