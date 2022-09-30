n = 2
words = ["hello", "one", "even", "never", "now", "world", "draw"]

def solution(n, words):
    answer = [0, 0]                                                         # [0]번째 사람이 [1]번째로 말함

    for i in range(1, len(words)):
        if words[i][0] == words[i-1][-1] and words[i] not in words[0:i]:    # 마지막 문자로 시작하고, 처음 등장하는지
            pass
        else:
            answer = [(i % n) + 1, (i // n) + 1]
            break

    return answer

print(solution(n, words))