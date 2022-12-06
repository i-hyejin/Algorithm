k = 80                                                      # 현재 피로도
dungeons = [[80, 20],[50, 40],[30, 10]]                     # 최소 필요 피로도, 소모 피로도

answer = 0
N = 0
visited = []

def dfs(k, cnt, dungeons):
    global answer
    if cnt > answer:                                        # answer보다 cnt가 크면
        answer = cnt                                        # cnt로

    for j in range(N):
        if k >= dungeons[j][0] and not visited[j]:          # 최소 필요 피로도를 충족하고 방문하지 않았으면
            visited[j] = 1                                  # 방문 처리
            dfs(k - dungeons[j][1], cnt + 1, dungeons)      # 다음 던전으로 방문
            visited[j] = 0                                  # 순서 바꿔서 생각하기 위해서 방문 미처리

def solution(k, dungeons):
    global N, visited
    N = len(dungeons)                                       # 던전의 개수
    visited = [0] * N                                       # 방문 여부

    dfs(k, 0, dungeons)                                     # 탐색

    return answer

print(solution(k, dungeons))