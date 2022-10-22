# input
t = int(input())

answer = 1
for _ in range(t):
    # l : 전체 학생 수, s : 등수, n : 성적 비율, k : 수행평가 개수, m : 수행평가 점수 기준, vi : 수행평가 점수
    data = list(map(int, input().split()))
    if data[1] > (data[0] * data[2] * 0.01):    # A+ 성적 비율 확인
        answer = 0
    else:
        for i in range(data[3]):                    # 과락 점수 확인
            if data[5 + i] <= data[4]:
                answer = 0

# output
print(answer)
