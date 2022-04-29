N = int(input())

count = 0

for h in range(N+1):                              # hour
    for m in range(60):                           # min
        for s in range(60):                       # sec
            if '3' in str(h) + str(m) + str(s):   # 3이 있으면 1 증가 (string 형변환)
               count += 1

print(count)                                      # 5 --> 11475
