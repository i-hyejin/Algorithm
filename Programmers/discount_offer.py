want = ["banana", "apple", "rice", "pork", "pot"]
number = [3, 2, 2, 2, 1]
discount = ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]

def solution(want, number, discount):
    answer = 0

    for i in range(len(discount)-9):
        sub = discount[i:i+10]                      # 10개씩 나누기
        flag = 0                                    # 개수가 동일한지 확인하는 변수
        for j in range(len(want)):                  # 물품 종류만큼 반복
            if sub.count(want[j]) != number[j]:     # 나눈 물품 종류의 개수와 원하는 물품 종류의 개수가 다르면
                flag = 1                            # flag를 1로 처리

        if flag == 0:                               # 개수가 모두 같으면
            answer += 1                             # 정답에 1 추가

    return answer

print(solution(want, number, discount))