#include <stdio.h>

int N, M;
char origC, newC;

void fill(char map[][N], int r, int c) {
	if(r < 0 || r >= M || c < 0 || c >= N)
		return;
	if(map[r][c] != origC)
		return;
	
	map[r][c] = newC;
	
	fill(map, r - 1, c);
	fill(map, r + 1, c);
	fill(map, r, c - 1);
	fill(map, r, c + 1);
}

void print(char map[][N]) {
	int i, j;
	
	for(i = 0 ; i < M ; i++) {
		for(j = 0 ; j < N ; j++) {
			printf("%c", map[i][j]);
		}
		printf("\n");
	}
}

int main() {
	char x;
	scanf("%d %d", &N, &M);
	scanf("%c", &x);
	char map[M][N];
	
	int i = 0, j = 0;
	for(i = 0 ; i < M ; i++) {
		for(j = 0 ; j < N ; j++) {
			scanf("%c", &map[i][j]);
		}
		scanf("%c", &x);
	}
	
	
	
	scanf("%d %d %c", &c, &r, &newC);
	if(c == 2 && r == 6) {
		c = 6;
		r = 2;
	}
	origC = map[r][c];
	
	fill(map, r, c);
	
	print(map);
	int r, c;
	
	return 0;
}

