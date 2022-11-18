progresses = [93, 30, 55]
speeds = [1, 30, 5]

import math

def solution(progresses, speeds):
    answer = []

    remain = []                                                     # 남은 작업 일수
    for i in range(len(progresses)):                                # 남은 작업 일수 계산
        remain.append(math.ceil((100-progresses[i]) / speeds[i]))

    work = remain.pop(0)                                            # 첫 번째 작업 뽑기
    day = 1                                                         # 작업 일수 1일차

    while remain:                                                   # remain이 비어있을 때까지
        temp = remain.pop(0)                                        # 작업 뽑기
        if work < temp:                                             # 기존 작업보다 오래 걸리면
            work = temp                                             # 기존 작업에 업데이트
            answer.append(day)                                      # 작업 개수 추가
            day = 1                                                 # 작업 일수 초기화
        else:                                                       # 기존 작업보다 덜 걸리면
            day += 1                                                # 작업 일수 추가
    answer.append(day)

    return answer

print(solution(progresses, speeds))