# input
n = int(input())
s = input()

# seperate character
tmp = s[0]
answer = 1
for i in range(1, n):
    if tmp != s[i]:
        answer += 1
        tmp = s[i]

# output
print(answer)