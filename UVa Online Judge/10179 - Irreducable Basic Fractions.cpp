/*
	Link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1120

	> Prime factor sieve part by Austin
	> Initial problem was with duplicate primes, fixed it by putting while block inside the if block
	> Final problem was overflow with int, fixed it by dividing first before multiplying
*/

#include <cstdio>
#include <cmath>
#include <cstring>
#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <algorithm>
#include <bits/stdc++.h>

using namespace std;

typedef vector<int> vi;
typedef pair<int,int> ii;
typedef vector<ii> vii;
typedef long long ll;
typedef pair<int,ii> iii;

#define MAX_N 32768

int main() {
	bitset<MAX_N + 1> sieve;
	vi primes;
	for(int i = 2; i <= MAX_N; i++) {
		if(!sieve.test(i)) {
			primes.push_back(i);
			if(i <= (int)sqrt(MAX_N)) {
				for(int j = i * i; j <= MAX_N; j += i) {
					sieve.set(j);
				}
			}
		}
	}
	
	int n = -1;
	scanf("%d",&n);
	while(n != 0) {
		vi pf;
		
		int temp = n;
		for(int i = 0; i < primes.size() && primes[i] * primes[i] <= temp; i++) {
			if(temp % primes[i] == 0) {
//				printf("%d %d\n",n, primes[i]);
				n /= primes[i];
				n *= (primes[i] - 1);
//				printf("%d\n",n);
				while(temp % primes[i] == 0) {
					pf.push_back(primes[i]);
					temp /= primes[i];
				}
			}
		}
		if(temp != 1) {
//			printf("%d\n",temp);
			n /= temp;
			n *= (temp - 1);
//			printf("%d\n",n);
			pf.push_back(temp);
		}
		
		printf("%d\n",n);
		scanf("%d",&n);
	}
}
