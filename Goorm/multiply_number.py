# input
nums = list(map(int, input().split()))

# calc
answer = 1
for n in nums:
	answer *= n

# output
print(answer)