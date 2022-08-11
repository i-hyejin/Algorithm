array = [1, 5, 2, 6, 3, 7, 4]
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]

def solution(array, commands):
    answer = []

    for c in range(len(commands)):
        new_list = sorted(array[commands[c][0]-1:commands[c][1]])   # 새로운 배열 만들기
        answer.append(new_list[commands[c][2]-1])                   # k번째 수 구하기

    return answer

print(solution(array, commands))