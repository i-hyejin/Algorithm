people = [30, 40, 50, 60]
limit = 1000

def solution(people, limit):
    answer = 0
    front = 0                                           # 리스트의 처음부터 시작
    rear = len(people)-1                                # 리스트의 끝부터 시작

    people.sort()                                       # 정렬

    while front <= rear:
        answer += 1                                     # 보트 1개 추가
        if people[front] + people[rear] <= limit:       # 몸무게가 가장 적은 사람과 가장 많은 사람이 탑승
            front += 1                                  # front 1 증가
        rear -= 1                                       # rear 1 감소

    return answer

print(solution(people, limit))
