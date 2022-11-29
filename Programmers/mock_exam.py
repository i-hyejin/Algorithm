answers = [1,3,2,4,2]

def solution(answers):
    answer = []
    scores = [0] * 3                                                # 점수
    students = [[1, 2, 3, 4, 5],                                    # 찍는 방식
                [2, 1, 2, 3, 2, 4, 2, 5],
                [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]

    for i in range(len(answers)):
        for j in range(len(students)):
            if answers[i] == students[j][i % len(students[j])]:     # 정답과 찍은 번호가 같으면
                scores[j] += 1                                      # 해당 학생에게 점수 추가

    max_correct = max(scores)                                       # 1등 점수
    for i in range(len(scores)):
        if scores[i] == max_correct:                                # 높은 점수가 여럿인 경우
            answer.append(i+1)                                      # 맞힌 사람 추가

    return answer

print(solution(answers))