n = 2
m = 2
x = 0
y = 0
queries = [[2,1],[0,1],[1,1],[0,1],[2,1]]

def solution(n, m, x, y, queries):
    answer = 0

    row_start, row_end, col_start, col_end = x, x, y, y

    for i in range(len(queries) - 1, -1, -1):               # queries-1 개까지 거꾸로 반복
        direction, distance = queries[i]                    # 방향, 거리 변수에 저장

        if direction == 0:                                  # 열 증가 시켜보기
            col_end += distance                             # col_end 늘리기
            if col_end > m - 1:                             # 범위를 벗어나면
                col_end = m - 1                             # 끝 값으로
            if col_start != 0:                              # col_start가 0이 아니라면
                col_start += distance                       # col_start도 늘리기

        elif direction == 1:                                # 열 감소 시켜보기
            col_start -= distance                           # col_start 줄이기
            if col_start < 0:                               # 범위를 벗어나면
                col_start = 0                               # 0으로
            if col_end != m - 1:                            # col_end가 끝 값이 아니라면
                col_end -= distance                         # col_end도 줄이기

        elif direction == 2:                                # 행 증가 시켜보기
            row_end += distance                             # row_end 늘리기
            if row_end > n - 1:                             # 범위를 벗어나면
                row_end = n - 1                             # 끝 값으로
            if row_start != 0:                              # row_start가 0이 아니라면
                row_start += distance                       # row_start도 늘리기

        else:                                               # 행 감소 시켜보기
            row_start -= distance                           # row_start 줄이기
            if row_start < 0:                               # 범위를 벗어나면
                row_start = 0                               # 0으로
            if row_end != n - 1:                            # row_end가 끝 값이 아니라면
                row_end -= distance                         # row_end도 줄이기

        if row_start > n - 1 or row_end < 0 or col_start > m - 1 or col_end < 0:    # 쿼리 중 범위를 벗어나면
            return answer                                                           # answer만 return

    answer = (row_end - row_start + 1) * (col_end - col_start + 1)  # answer 계산

    return answer

print(solution(n, m, x, y, queries))