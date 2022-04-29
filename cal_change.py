N = 1260                            # 돈
count = 0                           # 동전의 개수
coin_array = [500, 100, 50, 10]     # 동전의 종류

for coin in coin_array:
    count += N // coin              # 돈에서 coin 나누기
    N %= coin                       # 남은 돈

print(count)                        # 6
