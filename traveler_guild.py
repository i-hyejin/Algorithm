n = int(input())
data = list(map(int, input().split()))
data.sort()

result = 0                                  # 총 그룹 수
count = 0                                   # 현재 그룹에 포함된 모험가의 수

for i in data:                              # 공포도가 낮은 모험가부터 공포도 확인
    count += 1                              # 현재 그룹에 모험가 포함시키기
    if count >= i:                          # 모험가의 수가 공포도 이상이면 그룹 결성
        result += 1                         # 그룹 수 1 증가
        count = 0                           # 모함가의 수 초기화

print(result)                               # 2 3 1 2 2 --> 2
