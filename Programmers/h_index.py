citations = [3, 0, 6, 1, 5]

def solution(citations):
    answer = 0

    c = sorted(citations)       # 정렬 (새로운 변수에 저장하기 위해서 sorted 사용)
    c = list(reversed(c))       # 반대로 정렬 후 리스트화

    for i in range(len(c)):     # 논문 n 편 중
        if c[i] >= i + 1:       # h 번 이상 인용된 논문이 h 편 이상이면
            answer = i + 1      # answer에 저장

    return answer

solution(citations)