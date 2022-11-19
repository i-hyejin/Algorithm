priorities = [2, 1, 3, 2]
location = 2

def solution(priorities, location):
    answer = 0

    urgent = max(priorities)                        # 가장 높은 우선순위

    while True:
        temp = priorities.pop(0)                    # 대기목록에서 하나 꺼내기

        if urgent == temp:                          # 하나 꺼낸 요소가 가장 높은 우선순위이면
            answer += 1                             # 프린트
            if location == 0:                       # 위치가 0이면,
                break                               # 반복문 중단
            else:                                   # 위치가 0이 아니면,
                location -= 1                       # 하나 프린트 했으므로 1 감소
            urgent = max(priorities)                # 가장 높은 우선순위 구하기

        else:                                       # 하나 꺼낸 요소가 가장 높은 우선순위가 아니면
            priorities.append(temp)                 # 대기목록의 제일 마지막에 넣기
            if location == 0:                       # 위치가 0이면,
                location = len(priorities) - 1      # 가장 마지막 위치로 변경
            else:                                   # 위치가 0이 아니면,
                location -= 1                       # 하나 프린트 했으므로 1 감소

    return answer
