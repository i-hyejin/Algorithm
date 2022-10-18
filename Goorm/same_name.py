# input
n, s = input().split()
names = [input() for _ in range(int(n))]

# find similar names
answer = 0
for i in range(int(n)):
    if s in names[i]:
        answer += 1

# output
print(answer)