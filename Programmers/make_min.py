A = [1,4,2]
B = [5,4,4]

def solution(A,B):
    answer = 0

    A = sorted(A)                   # A 오름차순 정렬
    B = sorted(B, reverse=True)     # B 내림차순 정렬

    for i in range(len(A)):
        answer += A[i] * B[i]       # 순서대로 곱하기

    return answer

print(solution(A, B))