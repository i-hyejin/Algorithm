data = input()                                  # 문자열 입력 받기, array로 들어감

result = int(data[0])                           # 첫 번째 string형 -> int형
for i in range(1, len(data)):                   # 문자의 개수만큼 반복
    num = int(data[i])                          # i번째 data string형 -> int형
    if num <= 1 or result <= 1:                 # num이 1보다 작거나, result가 1보다 작으면
        result += num                           # 더하기 연산 수행
    else:
        result *= num                           # 곱하기 연산 수행

print(result)                                   # 0 2 9 8 4 --> 576
