# N = 5
# stages = [2, 1, 2, 6, 2, 4, 3, 3]
N = 3
stages = [1, 1, 1]

def solution(N, stages):
    answer = []
    arrival_count = [0 for i in range(N+1)]                 # 도달한 사람의 수
    failure_cal = [0 for i in range(N)]                     # 실패율

    for i in stages:
        arrival_count[i-1] += 1                             # 도달한 사람의 수 추가

    challenge = sum(arrival_count)                          # 전체 클리어 한 사람의 수
    for i in range(N):
        if challenge > 0:                                   # 클리어 한 사람이 있으면
            failure_cal[i] = arrival_count[i] / challenge   # 실패율 계산
        else:                                               # 클리어 한 사람이 없으면
            failure_cal[i] = 0                              # 실패율 0 으로
        challenge -= arrival_count[i]                       # 전체 클리어 한 사람의 수에서 현재 스테이지 클리어 한 사람을 빼면 나머지 스테이지를 클리어 한 사람의 수를 구할 수 있음

    failure_sort = sorted(failure_cal, reverse=True)        # 실패율 내림차순 정렬
    for i in failure_sort:
        answer.append(failure_cal.index(i) + 1)             # 실패율의 index 찾아서 +1로 answer에 저장
        failure_cal[failure_cal.index(i)] = -1              # 실패율의 index를 -1로 바꾸기 (실패율 값이 중복인 인덱스 찾기 위함)

    return answer

print(solution(N, stages))