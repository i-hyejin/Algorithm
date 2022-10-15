# n, m, k = 4, 5, 1
# graph = [[4, 1, 2, 3, 3], [6, 1, 1, 3, 3], [5, 6, 1, 3, 2], [5, 5, 6, 5, 5]]

from collections import deque

# input
n, m, k = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dice = [2, 4, 1, 3, 5, 6]                                       # 초기 주사위 위치
x, y = 0, 0                                                     # 초기 위치
d = 0                                                           # 초기 이동 방향
dx = [0, 1, 0, -1]                                              # 동, 남, 서, 북(시계방향)
dy = [1, 0, -1, 0]
answer = 0                                                      # 점수


def change_dice(dice, d):                                       # 주사위 방향 함수
    if d == 0:                                                  # 동쪽으로 이동 [2, 4, 1, 3, 5, 6] -> [2, 6, 4, 1, 5, 3]
        dice[1], dice[2], dice[3], dice[5] = dice[5], dice[1], dice[2], dice[3]
    elif d == 1:                                                # 남쪽으로 이동 [2, 4, 1, 3, 5, 6] -> [6, 4, 2, 3, 1, 5]
        dice[0], dice[2], dice[4], dice[5] = dice[5], dice[0], dice[2], dice[4]
    elif d == 2:                                                # 서쪽으로 이동 [2, 4, 1, 3, 5, 6] -> [2, 1, 3, 6, 5, 4]
        dice[1], dice[2], dice[3], dice[5] = dice[2], dice[3], dice[5], dice[1]
    elif d == 3:                                                # 북쪽으로 이동 [2, 4, 1, 3, 5, 6] -> [1, 4, 5, 3, 6, 2]
        dice[0], dice[2], dice[4], dice[5] = dice[2], dice[4], dice[5], dice[0]

    return dice

def move_dice(x, y, d):                                         # 주사위 움직여서 위치 구하기
    nx = x + dx[d]
    ny = y + dy[d]

    if 0 <= nx < n and 0 <= ny < m:                             # 이동 방향으로 한 칸 구르기
        return nx, ny, d

    else:                                                       # 칸이 없으면 반대 방향으로 한 칸 구르기
        nd = (d + 2) % 4                                        # 반대 방향 보기
        nx = x + dx[nd]
        ny = y + dy[nd]
        return nx, ny, nd

def bfs(x, y):                                                  # 주변 탐색하기
    count = 0
    visited = [[0] * m for _ in range(n)]

    q = deque()
    q.append((x, y))                                            # 칸의 위치 추가

    while q:
        a, b = q.popleft()                                      # 하나 꺼내기
        visited[a][b] = 1                                       # 방문 체크

        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if graph[a][b] == graph[nx][ny] and visited[nx][ny] == 0:
                    visited[nx][ny] = 1                         # 방문 체크
                    q.append((nx, ny))                          # 칸의 위치 추가

    for i in range(n):                                          # 방문 횟수 세기
        count += visited[i].count(1)

    return count

for _ in range(k):                                              # k번 이동
    # step 1. 주사위의 이동
    x, y, d = move_dice(x, y, d)

    # step 2. 주사위 전개도 구하기
    dice = change_dice(dice, d)

    # step 3. 주사위가 도착한 칸의 점수 계산
    count = bfs(x, y)                                           # 칸의 개수
    answer += graph[x][y] * count                               # 점수 계산

    # step 4. 주사위 이동 방향 결정
    A = dice[5]                                                 # 주사위의 바닥면
    B = graph[x][y]                                             # 현재 위치의 값
    if A > B:                                                   # 시계 방향
        d = (d + 1) % 4
    elif A < B:                                                 # 반시계 방향
        d = d - 1
        if d == -1:                                             # 예외 처리
            d = 3
    else:                                                       # 변화 없음
        pass

print(answer)