s = 'one4seveneight'

def solution(s):
    # s : 문자열 배열

    answer = []

    dict_list = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']  # index - 숫자 변환 리스트
    stack = []  # 한 글자씩 확인

    for i in range(len(s)):
        c = s[i]  # 문자열에서 한 글자 가져오기
        answer.append(c) if c.isdigit() else stack.append(c)  # 숫자면 정답에 추가, 문자면 스택에 추가
        stack_join = ''.join(stack)  # 스택 단어 합치기

        if stack_join in dict_list:  # dict_list에 stack_join이 존재하면
            answer.append(str(dict_list.index(stack_join)))  # index(숫자)로 정답에 추가
            stack = []  # 스택 비우기

    return int(''.join(answer))

answer = solution(s)
print(answer)