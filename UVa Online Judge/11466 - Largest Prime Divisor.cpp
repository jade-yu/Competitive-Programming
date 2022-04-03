/*
	Link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2461
	
	Count up every time you get a prime factor, then get the latest number (given that you already have at least one existing prime factor)
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

typedef long long ll;
typedef vector<ll> vi;
typedef pair<int,int> ii;
typedef vector<ii> vii;
typedef pair<int,ii> iii;

#define MAX_N 40000000

int main() {
	bitset<MAX_N + 1> *sieve = new bitset<MAX_N + 1>();
	vi primes;
	for(ll i = 2; i <= MAX_N; i++) {
		if(!sieve->test(i)) {
			primes.push_back(i);
			if(i <= (ll)sqrt(MAX_N)) {
				for(ll j = i * i; j <= MAX_N; j += i) {
					sieve->set(j);
				}
			}
		}
	}
	
	ll n = -1;
	scanf("%lld",&n);
	while(n != 0) {
		vi pf;
		if(n < 0) {
			n *= -1;
		}
		
		ll temp = n;
		ll count = 0, max;
		for(ll i = 0; i < primes.size() && primes[i] * primes[i] <= temp; i++) {
			if(temp % primes[i] == 0) {
				count++;
				if(count > 0) {
					max = primes[i];
				}
				while(temp % primes[i] == 0) {
					temp /= primes[i];
				}
			}
		}
		if(temp != 1 && count > 0) {
			max = temp;
			count++;
		}
		
		if(count > 1) {
			printf("%lld\n",max);
		} else {
			printf("-1\n");
		}
		scanf("%lld",&n);
	}
}
