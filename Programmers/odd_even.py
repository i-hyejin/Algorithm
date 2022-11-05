num = 3

def solution(num):
    answer = ''
    if num % 2 == 0:        # 짝수이면
        answer = 'Even'
    else:                   # 홀수이면
        answer = 'Odd'
    return answer

print(solution(num))