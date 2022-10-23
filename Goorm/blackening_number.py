# input
n, k = map(int, input().split())
arr = list(map(int, input().split()))
answer = n

# find min
idx = arr.index(min(arr))
for i in range(k):
    cnt = 1
    left = arr[:idx-i]
    right = arr[idx+k-i:]
    left_cnt = len(left) // (k-1) + (1 if len(left) % (k-1) else 0)
    right_cnt = len(right) // (k-1) + (1 if len(right) % (k-1) else 0)
    answer = min(answer, cnt + left_cnt + right_cnt)

# output
print(answer)
