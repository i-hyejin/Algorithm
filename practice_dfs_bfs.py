from collections import deque

def dfs(graph, v, visited):
    # 1) 현재 노드를 방문 처리 & 출력

    # 2) 재귀적 방문

def bfs(graph, start, visited):
    # 1) deque 사용

    # 2) 현재 노드를 방문 처리

    # 3) 큐가 빌 때까지 반복
    while queue:
        # 4) 큐에서 원소 하나 출력

        # 5) 방문하지 않은 인접한 노드 큐에 삽입

# 각 노가 연결된 정보를 표현 (2차원 리스트) - 1번 배열부터 사용하기
graph = [[], [2, 3, 8], [1, 7], [1, 4, 5], [3, 5], [3, 4], [7], [2, 6, 8], [1, 7]]

# 각 노드가 방문한 정보를 표현 (1차원 리스트) - False로 초기화
visited = [False] * 9

# bfs 호출 - 1 2 3 8 7 4 5 6
dfs(graph, 1, visited)
visited = [False] * 9
bfs(graph, 1, visited)

