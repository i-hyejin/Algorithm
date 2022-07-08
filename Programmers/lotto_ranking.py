lottos = [44, 1, 0, 0, 31, 25]
win_nums = [31, 10, 45, 1, 6, 19]

def solution(lottos, win_nums):
    # lottos : 구매한 번호
    # win_nums : 당첨 번호

    answer = []

    ranking = [6, 6, 5, 4, 3, 2, 1]                 # ranking : 맞춘 개수 별 등수

    # 정렬 후 0 개수 찾기 & 정답 개수 찾기
    lottos.sort(reverse=False)                      # 구매한 번호 내림차순 정렬
    count_zero = lottos.count(0)                    # 0 개수

    lottos_set = set(lottos)                        # lottos 집합으로 만들어줌
    win_nums_set = set(win_nums)                    # win_nums 집합으로 만들어줌
    count_win = len(lottos_set & win_nums_set)      # 정답 개수(교집합 원소의 개수)

    # 최고, 최저 등수 반환
    answer.append(ranking[count_win+count_zero])    # 최고 등수
    answer.append(ranking[count_win])               # 최저 등수

    return answer

answer = solution(lottos, win_nums)
print(answer)