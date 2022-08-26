n = 15

def solution(n):
    answer = ''
    num_dict = [4, 1, 2]                        # 0일 때 4, 1일 때 1, 2일 때 2 사용

    while n:                                    # n이 나누어질 때까지
        if n % 3:                               # n을 3으로 나누었을 때 나머지가 있으면
            answer += str(num_dict[n % 3])      # 나머지에 해당하는 dict 추가
            n //= 3                             # n을 3으로 나누기
        else:                                   # n을 3으로 나누었을 때 나머지가 없으면(0이면)
            answer += str(num_dict[0])          # 나머지에 해당하는 dict[0] 추가
            n = n // 3 - 1                      # n을 3으로 나눈 후 1 뺴기

    return answer[::-1]                         # 반대로 뒤집기

print(solution(n))