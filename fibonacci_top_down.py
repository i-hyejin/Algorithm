d = [0] * 100                       # 저장 공간

def fibo(x):
    if x == 1 or x == 2:
        return 1
    if d[x] != 0:                   # 계산한 적 있으면
        return d[x]
    d[x] = fibo(x-1) + fibo(x-2)    # 계산한 적 없으면 점화식에 따라서 피보나치 결과 반환
    return d[x]

print(fibo(99))
