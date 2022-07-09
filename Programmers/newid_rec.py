import re

new_id = "...!@BaT#*..y.abcdefghijklm"

def solution(new_id):
    # new_id : 사용자가 입력한 아이디

    answer = ''

    # 1단계. 대문자 -> 소문자
    answer = new_id.lower()

    # 2단계. 특수문자 제거
    answer = re.sub('[^a-z0-9\-_.]', '', answer)

    # 3단계. 마침표(.) 연속을 1번으로
    answer = re.sub('(([.])\\2{1,})', '.', answer)

    # 4단계. 마침표(.) 처음/끝 제거
    answer = answer.strip('.')

    # 5단계. 빈 문자열이면 'a' 대입 & 6단계 16자 이상이면 15개 제외 제거
    answer = 'a' if len(answer) == 0 else answer[:15]

    # 6단계. 16자 이상이면 15개 제외 제거
    answer = answer.strip('.')

    # 7단계. 2자 이하면 마지막 문자 반복하기
    if len(answer) == 2:
        character = answer[-1:]
        answer += character

    return answer

answer = solution(new_id)
print(answer)