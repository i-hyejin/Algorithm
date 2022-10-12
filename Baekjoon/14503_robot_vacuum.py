# input
n, m = map(int, input().split())
r, c, d = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

# input
# n, m = 3, 3
# r, c, d = 1, 1, 0
# graph = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]

visited = [[0] * m for _ in range(n)]
dx = [-1, 0, 1, 0]                              # 북(0), 동(1), 남(2), 서(3) 순
dy = [0, 1, 0, -1]

def solution(n, m, r, c, d, graph):
    visited[r][c] = 1                                                   # 처음 방문하는 곳 청소
    answer = 1                                                          # 청소 횟수 1로 초기화

    while True:
        # 네 방향 확인
        flag = 0
        for i in range(4):
            nx = r + dx[(d+3)%4]                                        # (d+3)%4 가 왼쪽 방향
            ny = c + dy[(d+3)%4]
            d = (d+3)%4

            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:      # 범위 안에 있고, 0이면
                if visited[nx][ny] == 0:                                # 청소 전이면
                    visited[nx][ny] = 1                                 # 청소 처리
                    answer += 1                                         # 청소 횟수 1 증가
                    r, c = nx, ny                                       # 현재 위치 변경
                    flag = 1
                    break

        # 네 방향 모두 청소되어 있으면
        if flag == 0:
            if graph[r-dx[d]][c-dy[d]] == 1:                            # 후진했는데 벽
                return answer
                break
            else:                                                       # 후진했는데 벽이 아님
                r, c = r-dx[d], c-dy[d]

print(solution(n, m, r, c, d, graph))
