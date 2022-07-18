numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = 'right'

def solution(numbers, hand):
    # numbers : 눌러야 할 번호
    # hand : 오른손잡이, 왼손잡이

    answer = []
    keypad = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '0', '#']
    left_pos = keypad.index('*')                            # 왼손 위치
    right_pos = keypad.index('#')                           # 오른손 위치

    for i in range(len(numbers)):
        press_key = keypad.index(str(numbers[i]))           # 키패드 인덱스
        result = ''

        if press_key % 3 == 0:                              # 왼쪽 열이면 왼손
            result = 'left'
        elif press_key % 3 == 2:                            # 오른쪽 열이면 오른손
            result = 'right'
        else:                                               # 가운데 열이면 가까운 손으로
            left_diff = abs(press_key // 3 - left_pos // 3) + abs(press_key % 3 - left_pos % 3)
            right_diff = abs(press_key // 3 - right_pos // 3) + abs(press_key % 3 - right_pos % 3)
            if left_diff < right_diff:                      # 왼손이 가까우면 왼손
                result = 'left'
            elif left_diff > right_diff:                    # 오른손이 가까우면 오른손
                result = 'right'
            else:
                if hand == 'left':                          # 둘 다 가까우면 왼손잡이
                    result = 'left'
                else:                                       # 둘 다 가까우면 오른손잡이
                    result = 'right'

        if result == 'left':                                # 왼손이면
            left_pos = press_key                            # 손 위치를 왼손으로
            answer.append('L')
        else:                                               # 오른손이면
            right_pos = press_key                           # 손 위치를 오른손으로
            answer.append('R')

    return ''.join(answer)

answer = solution(numbers, hand)
print(answer)