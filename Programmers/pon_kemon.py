nums = [3, 3, 3, 2, 2, 2]

def solution(nums):
    answer = 0

    answer = min(len(set(nums)), len(nums)//2) # 주어진 배열의 종류나 //2 중 작은 값 선택
    return answer

print(solution(nums))
