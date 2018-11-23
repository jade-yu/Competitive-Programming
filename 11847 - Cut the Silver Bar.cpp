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
