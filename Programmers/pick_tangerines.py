k = 6
tangerine = [1, 3, 2, 5, 4, 5, 2, 3]

from collections import Counter
def solution(k, tangerine):
    answer = 0

    t_counter = Counter(tangerine).items()                          # 종류 별 개수 세기
    t_counter = sorted(t_counter, reverse=True, key=lambda x: x[1]) # 개수 기준으로 내림차순 정렬

    for key, value in t_counter:
        if k > 0:                                                   # 귤을 더 담아야 하면
            k -= value                                              # 현재 개수만큼 빼기
            answer += 1                                             # 한 종류 추가

    return answer

print(solution(k, tangerine))
