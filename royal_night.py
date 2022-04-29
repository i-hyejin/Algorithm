input_data = input()                                # a1 : 위치 입력받기
row = int(input_data[1])                            # 1 : input_data[1]
col = int(ord(input_data[0]) - int(ord('a')) + 1)   # a : input_data[0], ord : ascii 숫자

steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

result = 0
for step in steps:
    # 이동 가능한지 확인
    next_row = row + step[0]
    next_col = col + step[1]

    # 이동 가능하면 result 증가
    if next_row >= 1 and next_row <= 8 and next_col >= 1 and next_col <= 8:
        result += 1

print(result)                                       # a1 --> 2

