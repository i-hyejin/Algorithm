clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]

def solution(clothes):
    closet = {}
    answer = 1

    for cloth in clothes:
        if cloth[1] in closet.keys():               # 종류가 key에 있으면
            closet[cloth[1]].append(cloth[0])       # 해당 key에 item 넣기
        else:                                       # 종류가 key에 없으면
            closet[cloth[1]] = [cloth[0]]           # key 만들고 item 넣기

    for i in closet.values():
        answer *= len(i) + 1                        # value + 1 곱하기

    return answer-1

print(solution(clothes))
