s = '3people unFollowed me'

def solution(s):
    s = s.split(' ')
    for i in range(len(s)):
        s[i] = s[i].lower()                 # 모든 문자를 소문자로 바꾸기
        s[i] = s[i].capitalize()            # 첫 문자를 대문자로 바꾸기
    answer = ' '.join(s)                    # 리스트 한 문장으로 합치기
    return answer

print(solution(s))