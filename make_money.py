n, m = map(int, input().split())            # n가지 화폐, m원    n = 3, m = 7
array = []                                  # 가능한 화폐의 종류  2, 3, 5
for i in range(n):
    array.append(int(input()))

d = [10001] * (m+1)                         # DP 테이블 초기화

d[0] = 0                                    # bottom-up
for i in range(n):
    for j in range(array[i], m+1):
        if d[j - array[i]] != 10001:        # (i-k)원을 만드는 방법이 존재하는 경우
            d[j] = min(d[j], d[j - array[i]] + 1)

if d[m] == 10001:                           # m을 만드는 방법이 없는 경우
    print(-1)
else:
    print(d[m])                             # 2

