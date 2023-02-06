#include <stdio.h>

int main() {

	int M, N;
	int min = 0;
	int sum = 0, flag = 0;

	scanf("%d %d", &M, &N);
	
	for (int i = M; i <= N; i++) {
		for (int s = 1; s <= 100; s++) {
			if ((s*s) == i && flag == 0) {
				sum += i;
				min = i;
				flag = 1;
			}
			else if ((s*s) == i && flag == 1) {
				sum += i;
			}
		}
	}
	
	if (min == 0) {
		printf("-1");
	}
	else {
		printf("%d\n", sum);
		printf("%d\n", min);
	}
	

	return 0;
}