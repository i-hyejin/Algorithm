x = int(input())                            # 정수 x
d = [0] * 30001                             # x 최대 30000까지 올 수 있음

for i in range(2, x+1):                     # bottom-up
    d[i] = d[i-1] + 1
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2]+1)
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3]+1)
    if i % 5 == 0:
        d[i] = min(d[i], d[i // 5]+1)

print(d[x])                                 # 26 --> 3
