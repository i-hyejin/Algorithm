a = [1, 2, 3, 4]
b = [-3, -1, 0, 2]

for i in zip(a, b):
    print(i)

def solution(a, b):
    # a, b : 내적할 두 배열
    answer = 0
    answer = sum([i*j for (i, j) in zip(a, b)])
    return answer

answer = solution(a, b)
print(answer)
