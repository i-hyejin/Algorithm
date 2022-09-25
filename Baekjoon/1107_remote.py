import sys
n = int(input())
m = int(input())
broken_button = list(map(int, sys.stdin.readline().split()))

def solution(n, m, broken_button):
    now_ch = 100                                                                # 현재 채널
    answer = abs(now_ch - n)                                                    # 버튼을 누른 횟수. 초기화는 현재 채널-목표 채널

    for ch in range(1000000):                                                   # 100 -> 500000 or 999999 -> 500000
        str_ch = str(ch)                                                        # 문자열 변환

        for i in range(len(str_ch)):
            if int(str_ch[i]) in broken_button:                                 # str_ch 버튼이 broken_button에 있으면
                break                                                           # 계산할 필요 없음
            elif i == len(str_ch) - 1:                                          # str_ch 마지막 숫자이면(str 버튼이 broken_button에 없으면)
                answer = min(answer, abs(int(str_ch)-n)+len(str_ch))            # answer과 str_ch-n만큼 +- 버튼을 누른 후 str_ch 만큼 버튼을 누른 것 중 최소값

    return answer

print(solution(n, m, broken_button))