n, k = map(int, input().split())                # n, k 입력 받기
result = 0                                      # 연산 횟수

while True:
    target = (n // k) * k                       # n이 k로 나누어 떨어질 때까지 n의 값
    result += (n - target)                      # 연산 횟수 n-target 만큼 증가
    n = target                                  # n에 target 대입

    if n < k:                                   # n이 k보다 작을 때 연산 종료
        break

    result += 1                                 # 연산 횟수 1 증가
    n //= k                                     # n을 k로 나누기

result += (n - 1)
print(result)                                   # n = 25, k = 3, result = 6
