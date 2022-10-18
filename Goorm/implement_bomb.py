# input
n, k = map(int, input().split())
pos = [list(map(int, input().split())) for _ in range(k)]

# initalize var
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
graph = [[0] * n for _ in range(n)]

# bomb falls
for i in range(k):
    x = pos[i][0] - 1
    y = pos[i][1] - 1
    graph[x][y] += 1
    for j in range(4):
        nx = x + dx[j]
        ny = y + dy[j]
        if 0 <= nx < n and 0 <= ny < n:
            graph[nx][ny] += 1

# sum bomb value
answer = 0
for i in range(n):
    answer += sum(graph[i])

# output
print(answer)