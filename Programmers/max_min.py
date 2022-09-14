s = '-1 -2 -3 -4'

def solution(s):
    s_split = list(map(int, s.split(' ')))                 # 문자열 분리 후 정수화
    return str(min(s_split)) + ' ' + str(max(s_split))

print(solution(s))
