## 음료수 얼려 먹기
# (입력)
# 4 5
# 00110 / 00011 / 11111 / 00000
# (출력)
# 3

# DFS 사용
def dfs(x, y):
    # 주어진 범위를 벗어나면 즉시 종료
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    # 현재 노드를 방문하지 않았다면
    if graph[x][y] == 0:
        # 방문 처리
        graph[x][y] = 1
        # 상하좌우도 재귀적으로 호출
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

# n, m 공백을 기준으로 구분하여 입력 받기
n, m = map(int, input().split())

# 2차원 리스트의 맵 정보 입력 받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# 모든 노드에 대하여 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        # DFS 수행
        if dfs(i, j) == True:
            result += 1

print(result)