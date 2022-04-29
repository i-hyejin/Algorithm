n = int(input())                                    # 이동 횟수
x, y = 1, 1                                         # 초기 좌표
plans = input().split()                             # 이동 방향

dx = [0, 0, -1, 1]                                  # 행(세로) 이동
dy = [-1, 1, 0, 0]                                  # 열(가로) 이동
move = ['L', 'R', 'U', 'D']                         # 이동 방향 문자

for plan in plans:                                  # 이동 방향 하나씩 확인
    for i in range(len(move)):                      # 이동 방향 문자 안에 있으면
        if plan == move[i]:
            nx = x + dx[i]                          # 좌표 구하기
            ny = y + dy[i]

    if nx < 1 or ny < 1 or nx > n or ny > n:        # 공간 벗어나면 continue
        continue
    x, y = nx, ny                                   # 공간 벗어나지 않으면 적용

print(x, y)
