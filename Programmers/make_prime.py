nums = [1, 2, 7, 6, 4]

def isPrime(temp):
    if temp > 1:                                    # 1보다 크고
        for i in range(2, temp):                    # 2부터 temp 사이의 수로
            if temp % i == 0:                       # 나누어 떨어지면
                return False                        # False 반환(소수가 아님)
    else:
        return False                                # 1이면 False 반환(소수가 아님)
    return True                                     # True 반환(소수)

def solution(nums):
    # nums : 주어진 숫자의 배열
    answer = 0                                      # 소수의 개수 초기화
    len_num = len(nums)                             # 주어진 숫자의 개수

    for i in range(len_num):                        # 첫 번째 숫자
        for j in range(i+1, len_num):               # 두 번째 숫자
            for k in range(j+1, len_num):           # 세 번째 숫자
                temp = nums[i] + nums[j] + nums[k]  # 세 숫자를 모두 더했을 때
                if isPrime(temp) == True:           # 소수가 맞으면
                    answer += 1                     # 1 증가
    return answer

print(solution(nums))