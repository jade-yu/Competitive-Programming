//Link to problem: https://codeforces.com/problemset/problem/977/A

#include <stdio.h>

int main()
{
    int n, k, temp;
    scanf("%d %d", &n, &k);
    
    while(k > 0) {
    	if(n % 10 == 0) {
    		n /= 10;
    		k--;
		} else if(n % 10 >= k) {
			temp = k;
			k -= n % 10;
    		n -= temp;
		} else {
			k -= (n % 10 + 1);
			n /= 10;
		}
	}

	printf("%d", n);
	
    return 0;
}

