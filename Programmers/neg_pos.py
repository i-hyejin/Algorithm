absolutes = [4, 7, 12]
signs = [True, False, True]

def solution(absolutes, signs):
    # absolutes : 숫자 배열
    # signs : 숫자의 부호

    answer = 123456789

    # 음수 구하기
    list_a = [i for i in range(10)]
    for i in range(len(absolutes)):
        if signs[i] == False:
           absolutes[i] *= -1

    # 합 구하기
    answer = sum(absolutes)

    return answer

answer = solution(absolutes, signs)
print(answer)