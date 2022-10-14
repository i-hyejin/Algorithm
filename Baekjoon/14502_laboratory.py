from collections import deque
import copy

# input
# n, m = map(int, input().split())
# graph = [list(map(int, input().split())) for _ in range(n)]
# print(graph)

# input
n, m = 7, 7
graph = [[2, 0, 0, 0, 1, 1, 0], [0, 0, 1, 0, 1, 2, 0], [0, 1, 1, 0, 1, 0, 0], [0, 1, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 1, 1], [0, 1, 0, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0, 0]]

result = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    queue = deque()                             # 바이러스 위치를 저장할 deque 생성
    tmp = copy.deepcopy(graph)                  # 깊은 복사

    # 바이러스 위치 찾기
    for i in range(n):
        for j in range(m):
            if tmp[i][j] == 2:                  # 바이러스가 있으면
                queue.append((i, j))            # 큐에 추가

    # 바이러스가 모두 퍼질 때까지 반복
    while queue:
        x, y = queue.popleft()                  # 큐에서 하나씩 꺼내기

        for i in range(4):                      # 네 방향 확인
            nx = x + dx[i]
            ny = y + dy[i]

            if (0 <= nx < n) and (0 <= ny < m): # 범위 안에 있으면
                if tmp[nx][ny] == 0:            # 빈 칸이면
                    tmp[nx][ny] = 2             # 바이러스가 퍼짐
                    queue.append((nx, ny))      # 해당 위치 큐에 추가

    global result
    count = 0
    for i in range(n):
        count += tmp[i].count(0)

    result = max(result, count)

def make_wall(count):
    if count == 3:                              # 벽을 3개 세웠으면
        bfs()                                   # 탐색
        return

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:                # 아무것도 없으면
                graph[i][j] = 1                 # 벽 1개 세우기
                make_wall(count + 1)            # 벽 1개 더 세우기
                graph[i][j] = 0                 # 원상복귀

make_wall(0)
print(result)
