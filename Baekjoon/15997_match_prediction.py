# nations = ['KOREA', 'CCC', 'BBB', 'AAA']
# rates = [['KOREA', 'CCC', 1.0, 0.0, 0.0],
#          ['AAA', 'BBB', 0.428, 0.144, 0.428],
#          ['AAA', 'KOREA', 0.0, 0.0, 1.0],
#          ['CCC', 'BBB', 0.0, 0.0, 1.0],
#          ['KOREA', 'BBB', 1.0, 0.0, 0.0],
#          ['CCC', 'AAA', 0.0, 0.0, 1.0]]

import copy

nations = list(map(str, input().split()))
rates = []
for i in range(6):
    rates.append(list(map(str, input().split())))

datas = [ [[0, 0, 0] for i in range(4)] for i in range(4) ]     # 팀별 승률 정리(win, draw, lose)
result = [0, 0, 0, 0]

def match(order, score, p):
    combination = [(0, 1), (0, 2), (0, 3), (1, 2), (1, 3), (2, 3)]

    if order == 6:                                              # 6번 경기를 다 하면
        score_sort = [[s, i] for i, s in enumerate(score)]
        score_sort = sorted(score_sort, reverse=True)           # 내림차순 정렬

        # 4팀의 승점이 같을 경우
        if score_sort[0][0] == score_sort[1][0] == score_sort[2][0] == score_sort[3][0]:
            result[score_sort[0][1]] += p * 2 / 4
            result[score_sort[1][1]] += p * 2 / 4
            result[score_sort[2][1]] += p * 2 / 4
            result[score_sort[3][1]] += p * 2 / 4


        # 3팀의 승점이 같을 경우
        elif score_sort[0][0] == score_sort[1][0] == score_sort[2][0]:
            result[score_sort[0][1]] += p * 2 / 3
            result[score_sort[1][1]] += p * 2 / 3
            result[score_sort[2][1]] += p * 2 / 3


        # 2팀의 승점이 같을 경우
        elif score_sort[0][0] == score_sort[1][0]:
            result[score_sort[0][1]] += p * 2 / 2
            result[score_sort[1][1]] += p * 2 / 2


        # 1팀은 확정, 3팀의 승점이 같을 경우
        elif score_sort[1][0] == score_sort[2][0] == score_sort[3][0]:
            result[score_sort[0][1]] += p * 1
            result[score_sort[1][1]] += p * 1 / 3
            result[score_sort[2][1]] += p * 1 / 3
            result[score_sort[3][1]] += p * 1 / 3


        # 1팀은 확정, 2팀의 승점이 같을 경우
        elif score_sort[1][0] == score_sort[2][0]:
            result[score_sort[0][1]] += p * 1
            result[score_sort[1][1]] += p * 1 / 2
            result[score_sort[2][1]] += p * 1 / 2

        # 1팀은 확정, 1팀도 확정
        else:
            result[score_sort[0][1]] += p * 1
            result[score_sort[1][1]] += p * 1

    else:
        team1 = combination[order][0]
        team2 = combination[order][1]

        # team1 win
        temp = copy.deepcopy(score)
        temp[team1] += 3
        match(order+1, temp, p*datas[team1][team2][0])

        # team1 draw
        temp = copy.deepcopy(score)
        temp[team1] += 1
        temp[team2] += 1
        match(order+1, temp, p*datas[team1][team2][1])

        # team1 lose
        temp = copy.deepcopy(score)
        temp[team2] += 3
        match(order+1, temp, p*datas[team1][team2][2])

def solution(nations, rates):

    # 승률 정리
    for i in range(6):
        team1 = nations.index(rates[i][0])     # team1의 index
        team2 = nations.index(rates[i][1])     # team2의 index
        datas[team1][team2] = [float(rates[i][2]), float(rates[i][3]), float(rates[i][4])]   # team1의 win, draw, lose
        datas[team2][team1] = [float(rates[i][4]), float(rates[i][3]), float(rates[i][2])]   # team2의 win, draw, lose

    match(0, [0, 0, 0, 0], 1.0)

    for i in range(4):
        print('%.7f' % result[i])

    return result

solution(nations, rates)