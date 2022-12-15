n = 15

def solution(n):
    answer = []

    for i in range(1, n, 2):        # 홀수이면서
        if n % i == 0:              # n의 약수인 경우
            answer.append(i)

    return len(answer) + n % 2      # n이 홀수면 한 번 더 가능

print(solution(n))