# input
n, k = map(int, input().split())
data = []
for _ in range(n):
	name, height = map(str, input().split())
	data.append((name, format(float(height), '.2f')))

# sort by key
data.sort(key = lambda x: (x[0], x[1]))

# output
print(data[k-1][0], data[k-1][1])