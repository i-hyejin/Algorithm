# input
n = int(input())
bridge = list(map(int, input().split()))

# calc
answer = bridge[0]
for i in range(1, n):
	answer *= bridge[i]

# output
print(answer)