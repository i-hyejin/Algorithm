name = 'JEROEN'

def solution(name):
    answer = 0
    min_move = len(name) - 1                                                                # 좌우이동 횟수

    for i, char in enumerate(name):
        answer += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)                       # char~A, Z~char 중 비교
        next = i + 1                                                                        # 다음 알파벳
        while next < len(name) and name[next] == 'A':                                        # A 문자열이 있으면
            next += 1                                                                       # next 1 증가

        min_move = min([min_move, 2 * i + len(name) - next, i + 2 * (len(name) - next)])    # 기존, 왼쪽 시작, 오른쪽 시작 비교

    answer += min_move
    return answer

print(solution(name))