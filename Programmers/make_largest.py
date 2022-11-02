number = '1924'
k = 2

def solution(number, k):
    answer = []

    for i in number:
        while k > 0 and answer and answer[-1] < i:      # k가 0보다 크고, answer가 존재하며, 마지막 수가 현재 수보다 작은 경우
            answer.pop()                                # answer에서 하나 제거하기
            k -= 1                                      # k 하나 줄이기
        answer.append(i)                                # 조건을 만족하지 않으면 number 넣기

    return ''.join(answer[:len(answer) - k])

print(solution(number, k))