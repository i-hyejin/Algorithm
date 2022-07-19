numbers = [1,2,3,4,6,7,8,0]

def solution(numbers):
    # numbers : 숫자를 찾을 리스트
    answer = -1

    # 0부터 10까지의 합
    sum_toten = 0
    for i in range(0, 10):
        sum_toten += i

    # numbers의 합
    sum_numbers = sum(numbers)

    # 두 합의 차 return
    answer = sum_toten-sum_numbers

    return answer

answer = solution(numbers)
print(answer)
