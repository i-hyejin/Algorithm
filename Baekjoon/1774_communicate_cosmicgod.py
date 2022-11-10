import math

# 크루스칼 알고리즘
def find(x):
    return x if parent[x] == x else find(parent[x])

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[a] = b
    else:
        parent[b] = a

n, m = map(int, input().split())

graph = [[]]                                                # 좌표 리스트
parent = [i for i in range(n+1)]                            # 좌표의 부모 리스트

for i in range(n):
    graph.append(list(map(int, input().split())))           # 위치 graph에 추가

for i in range(m):
    a, b = map(int, input().split())                        # 이미 연결된 경로 이어주기
    union(a, b)

temp = []
for a in range(1, n+1):
    for b in range(a+1, n+1):
        if find(a) != find(b):                              # a, b의 parent가 다르면
            x1, y1 = graph[a]                               # a의 좌표
            x2, y2 = graph[b]                               # b의 좌표
            cost = math.dist((x1, y1), (x2, y2))            # 두 점 사이의 거리 계산
            temp.append((cost, a, b))                       # cost, a, b 정보 temp에 저장

temp.sort()                                                 # cost 기준으로 오름차순 정렬

answer = 0
for cost, a, b in temp:
    if find(a) != find(b):                                  # a, b의 parent가 다르면
        union(a, b)                                         # a, b 합치기
        answer += cost                                      # 거리 합하기

print(format(answer, '.2f'))                                # 소수 둘째자리까지 출력