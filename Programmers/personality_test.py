survey = ["AN", "CF", "MJ", "RT", "NA"]
choices = [5, 3, 2, 7, 5]

def solution(survey, choices):
    answer = []

    k_character = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0}

    for i in range(len(survey)):
        if choices[i] < 4:  # 값이 4보다 작으면
            k_character[survey[i][0]] += 4 - choices[i]  # 첫 번째 유형에 점수 더하기
        if choices[i] > 4:  # 값이 4보다 크면
            k_character[survey[i][1]] += choices[i] - 4  # 두 번째 유형에 점수 더하기

    if k_character['R'] < k_character['T']:
        answer.append('T')
    else:
        answer.append('R')

    if k_character['C'] < k_character['F']:
        answer.append('F')
    else:
        answer.append('C')

    if k_character['J'] < k_character['M']:
        answer.append('M')
    else:
        answer.append('J')

    if k_character['A'] < k_character['N']:
        answer.append('N')
    else:
        answer.append('A')

    return ''.join(answer)

print(solution(survey, choices))
