import math

# input
n = int(input())
a = list(map(int, input().split()))


# define isPrime function
def isPrime(tmp):
    if tmp > 1:
        for i in range(2, int(math.sqrt(tmp)) + 1):  # 제곱근까지 확인
            if tmp % i == 0:
                return False
    else:
        return False
    return True


# find prime number
answer = 0
for i in range(n):
    if isPrime(i + 1):
        answer += a[i]

# output
print(answer)