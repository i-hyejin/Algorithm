# input
t = int(input())
for _ in range(t):
    n = int(input())
    score = list(map(int, input().split()))

    # calc
    mean = sum(score) / len(score)
    success = 0
    for s in score:
        if s >= mean:
            success += 1

    # output
    print(f'{success}/{n}')