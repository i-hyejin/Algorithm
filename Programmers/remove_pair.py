s = 'baabaa'

def solution(s):
    answer = 0
    stack = []

    for i in range(len(s)):                                 # 주어진 문자열의 개수만큼 반복
        if len(stack) > 0 and stack[-1] == s[i]:            # stack이 비어 있지 않고, 이전 문자와 현재 문자가 같으면
            stack.pop()                                     # stack에 마지막 문자 빼기
        else:
            stack.append(s[i])                              # stack에 현재 문자 넣기

    if len(stack) == 0:                                     # stack이 비어 있으면
        answer = 1                                          # 짝지어 제거하기 성공

    return answer

print(solution(s))