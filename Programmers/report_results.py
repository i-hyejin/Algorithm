id_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
k = 2

def solution(id_list, report, k):
    # id_list : 이용자 id 배열
    # report : 신고한 id 배열
    # k : 기준이 되는 신고 횟수

    answer = [0] * len(id_list)
    reports = {x : 0 for x in id_list}                  # 신고 기록 정리

    for r in set(report):
        reports[r.split()[1]] += 1                      # 신고자 횟수 1 증가

    for r in set(report):
        if reports[r.split()[1]] >= k:                  # k번 이상 신고되었으면
            answer[id_list.index(r.split()[0])] += 1    # 신고자에게 메일 1 증가

    return answer

answer = solution(id_list, report, k)
print(answer)