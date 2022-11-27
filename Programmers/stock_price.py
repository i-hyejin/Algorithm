prices = [1, 2, 3, 2, 3]

from collections import deque

def solution(prices):
    answer = []

    q = deque(prices)           # prices를 deque로 생성
    while q:                    # q가 비어있을 때까지
        temp = q.popleft()      # 하나 꺼내기
        period = 0              # 지나간 시간
        for price in q:         # q에 있는 가격들 반복
            if temp > price:    # 꺼낸 가격이 q에 있는 가격보다 비싸면
                period += 1     # 시간만 증가하고 반복문 나오기
                break
            else:               # 꺼낸 가격이 q에 있는 가격보다 싸면
                period += 1     # 시간만 증가
        answer.append(period)   # 최종 시간 answer에 저장

    return answer

print(solution(prices))