n = 15

def solution(n):
    answer = 0

    for i in range(1, n + 1):           # 1부터 n+1까지 반복
        sum = 0                         # 연속된 자연수를 더한 합
        for j in range(i, n + 1):       # i부터 n+1까지 반복
            sum += j                    # 합에 자연수 더하기
            if sum > n:                 # 합이 n보다 크면
                pass                    # 나머지 반복문은 패스
            if sum == n:                # 합이 n 이면
                answer += 1             # 1가지 방법 찾음
                pass                    # 나머지 반복문은 패스

    return answer

print(solution(n))