# 2 (Test case)
# 3 4 (n*m)
# 1 3 3 2 2 1 4 1 0 6 4 7 (gold 개수) --> 19
# 4 4 (n*m)
# 1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2 (gold 개수) --> 16

for tc in range(int(input())):
    n, m = map(int, input().split())
    array = list(map(int, input().split()))

    dp = []
    index = 0
    for i in range(n):
        dp.append(array[index:index+m])
        index += m

    for j in range(1, m):
        for i in range(n):
            # 왼쪽 위에서 오는 경우
            if i == 0: left_up = 0                  # 인덱스 고려
            else: left_up = dp[i-1][j-1]
            # 왼쪽 아래에서 오는 경우
            if i == n-1: left_down = 0              # 인덱스 고려
            else: left_down = dp[i+1][j-1]
            # 왼쪽에서 오는 경우
            left = dp[i][j-1]

            dp[i][j] = dp[i][j] + max(left_up, left_down, left)     # 현재 위치 + 최대값

    result = 0
    for i in range(n):
        result = max(result, dp[i][m-1])
    print(result)
