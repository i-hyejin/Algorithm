# input
num = list(map(int, input().split()))

# calc
num.sort()
answer = abs(num[0]-num[2]) + abs(num[1]-num[3])

# output
print(answer)