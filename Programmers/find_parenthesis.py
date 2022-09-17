s = "(()("

# solution1 : append, pop을 이용한 풀이
def solution1(s):
    stack = []

    for i in range(len(s)):
        if s[i] == '(':                     # 왼쪽 괄호이면
            stack.append('(')               # 스택에 추가
        else:                               # 오른쪽 괄호이면(문제에서 문자열은 괄호 2종류만 나옴)
            if not stack:                   # 스택이 비어 있으면
                return False                # pop 할 괄호가 없으므로 return False
            else:                           # 스택이 있으면
                stack.pop()                 # pop

    return True if not stack else False     # 스택이 비어 있으면 return True, 스택이 있으면 닫히지 않았으므로 False

# solution2 : check의 integer value를 이용한 풀이
def solution2(s):
    check = 0

    for i in range(len(s)):
        if s[i] == '(':                     # 왼쪽 괄호이면
            check += 1                      # check에 1 증가
        else:
            if check < 1:                   # check가 1보다 작으면(왼쪽 괄호가 등장하기 전)
                return False                # 왼쪽 괄호가 없으므로 return False
            else:                           # check가 양수이면
                check -= 1                  # check에 1 감소

    return True if check == 0 else False    # check가 0이면 return True, 값이 있으면 False

print(solution1(s))
print(solution2(s))