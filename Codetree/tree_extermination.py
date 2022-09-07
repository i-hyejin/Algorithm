# # input
n, m, k, c = map(int, input().split())
graph = [[0] * n for _ in range(n)]
for i in range(len(graph)):
    trees = list(map(int, input().split()))
    for j in range(len(graph[0])):
        graph[i][j] = trees[j]

# input(test)
# n, m, k, c = 5, 2, 2, 1
# graph = [[0, 0, 0, 0, 0], [0, 30, 23, 0, 0], [0, 0, -1, 0, 0], [0, 0, 17, 46, 77], [0, 0, 0, 12, 0]]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

dx_d = [-1, 1, -1, 1]
dy_d = [1, 1, -1, -1]

def solution(n, m, k, c, graph):
    c_value = (-10) - c
    answer = 0

    for m_year in range(m):

        # 제초제 1년 후로
        for i in range(len(graph)):
            for j in range(len(graph[0])):
                if graph[i][j] < -10:                                                                                   # -10보다 작으면 (아직 제초제가 있으면)
                    graph[i][j] += 1                                                                                    # 1년이 지났으니 1 더해줌

        # 그래프 하나 더 만들기
        origin_graph = [[0] * n for _ in range(n)]
        for i in range(len(graph)):
            for j in range(len(graph[0])):
                origin_graph[i][j] = graph[i][j]

        # 1. 나무의 성장
        for i in range(len(origin_graph)):
            for j in range(len(origin_graph[0])):
                if origin_graph[i][j] > 0:                                                                              # 나무가 있으면
                    for d in range(len(dx)):                                                                            # 사방 탐색
                        nx = i + dx[d]
                        ny = j + dy[d]
                        if nx < 0 or ny < 0 or nx >= n or ny >= n:                                                      # 범위를 벗어나면
                            continue
                        if origin_graph[nx][ny] > 0:                                                                    # 탐색한 곳에 값이 있으면
                            graph[i][j] += 1                                                                            # 나무 성장 시키기

        # 2. 나무의 번식
        for i in range(len(origin_graph)):
            for j in range(len(origin_graph[0])):
                if origin_graph[i][j] > 0:                                                                              # 나무가 있으면
                    nx_list = []
                    ny_list = []
                    for d in range(len(dx)):                                                                            # 사방 탐색
                        nx = i + dx[d]
                        ny = j + dy[d]
                        if nx < 0 or ny < 0 or nx >= n or ny >= n:                                                      # 범위를 벗어나면
                            continue
                        if origin_graph[nx][ny] == 0:                                                                   # 탐색한 곳에 나무가 없으면
                            nx_list.append(nx)                                                                          # 해당 좌표 리스트에 저장
                            ny_list.append(ny)

                    if len(nx_list) > 0:                                                                                # 리스트가 존재하면
                        n_tree = graph[i][j] // len(nx_list)                                                            # 번식할 나무 그루 수 계산
                        for d in range(len(nx_list)):
                            graph[nx_list[d]][ny_list[d]] += n_tree                                                     # 나무 번식시키기

        max_sum = 0                                                                                                     # 최대 박멸 나무 그루 수
        max_i = 0
        max_j = 0

        # 3. 제초제
        for i in range(len(graph)):
            for j in range(len(graph[0])):
                if graph[i][j] > 0:                                                                                     # 나무가 없을 때, 벽이 없을 때, 제초제가 없을 때 고려 (나무가 있을 때)
                    temp_sum = 0                                                                                        # 현재 위치에서 박멸 나무 그루 수
                    temp_sum += graph[i][j]
                    for d in range(len(dx_d)):
                        state = 0
                        for r in range(1, k + 1):                                                                       # 첫 번째 대각선부터 탐색
                            if state == 1:
                                break
                            nx = i + r * dx_d[d]
                            ny = j + r * dy_d[d]
                            if nx < 0 or ny < 0 or nx >= n or ny >= n:                                                  # 범위를 벗어나면
                                continue
                            if graph[nx][ny] <= 0:                                                                      # 나무가 없거나, 벽이거나, 제초제가 뿌려진 곳
                                state = 1
                            if graph[nx][ny] > 0:                                                                       # 나무가 있는 곳
                                temp_sum += graph[nx][ny]                                                               # 박멸 나무 그루 수에 더하기

                    if temp_sum > max_sum:
                        max_sum = temp_sum
                        max_i = i
                        max_j = j

        if graph[max_i][max_j] == 0:                                                                                    # 현재 위치에 나무가 없으면
            graph[max_i][max_j] = c_value                                                                               # 현재 위치만 처리
        else:                                                                                                           # 현재 위치에 나무가 있으면
            graph[max_i][max_j] = c_value                                                                               # 현재 위치 처리
            for d in range(len(dx_d)):
                state = 0
                for r in range(1, k + 1):
                    if state == 1:
                        break
                    nx = max_i + r * dx_d[d]
                    ny = max_j + r * dy_d[d]
                    if nx < 0 or ny < 0 or nx >= n or ny >= n:                                                          # 범위를 벗어나면
                        continue
                    if graph[nx][ny] == 0:                                                                              # 나무가 없는 곳은 제초제 처리함
                        state = 1
                        graph[nx][ny] = c_value
                    if graph[nx][ny] < -1:                                                                              # 제초제가 뿌려진 곳은 제초제 처리함
                        state = 1
                        graph[nx][ny] = c_value
                    if graph[nx][ny] == -1:                                                                             # 벽이 있는 곳은 제초제 처리를 하지 않음
                        state = 1
                    if state == 0 and graph[nx][ny] > 0:                                                                # 나무가 있는 곳은 제초제 처리함
                        graph[nx][ny] = c_value

        answer += max_sum

        # 제초제 다된거 확인
        for i in range(len(graph)):
            for j in range(len(graph[0])):
                if graph[i][j] == -10:                                                                                  # 제초제 값이 -10 이면 처리 끝남
                    graph[i][j] = 0                                                                                     # 해당 위치 0으로 바꾸기

    return answer

print(solution(n, m, k, c, graph))