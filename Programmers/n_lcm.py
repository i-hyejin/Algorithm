arr = [2, 7, 14]

import math
def solution(arr):
    arr.sort()                                              # 배열 정렬
    answer = arr[0]                                         # 가장 작은 수로 시작

    for i in arr:
        # 2개의 최소공배수를 구하고 answer에 저장 후 다시 최소공배수 구하기
        answer = (i * answer) // math.gcd(i, answer)
    return answer

print(solution(arr))