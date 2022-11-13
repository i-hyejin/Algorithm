topping = [1, 2, 1, 3, 1, 4, 1, 2]

from collections import Counter
def solution(topping):
    answer = 0

    old_bro = Counter(topping)              # 형 : topping을 Counter로 초기화
    young_bro = set()                       # 동생 : set으로 초기화

    for i in topping:                       # topping에서 하나씩 고려함
        old_bro[i] -= 1                     # old_bro 하나 빼기
        young_bro.add(i)                    # young_bro 하나 더하기
        if old_bro[i] == 0:                 # old_bro 요소의 개수가 0이면
            del old_bro[i]                  # 해당 요소 제거하기
        if len(old_bro) == len(young_bro):  # 만약 old_bro와 young_bro의 요소의 종류의 개수가 같으면
            answer += 1                     # 가능한 경우 1 추가

    return answer

print(solution(topping))
