id_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
k = 2

def solution(id_list, report, k):
    # id_list : 이용자 id 배열
    # report : 신고한 id 배열
    # k : 기준이 되는 신고 횟수

    answer = []

    id_count = [0 for i in range(len(id_list))]      # id_count : 신고 횟수
    report_list = [[] for i in range(len(id_list))]  # report_list : 누가 신고했는지
    id_mail = [0 for i in range(len(id_list))]       # id_mail : 결과 메일 횟수

    # report에서 신고 횟수 누적 & 신고자 기록
    for i in range(len(report)):
        report_who = report[i].split(' ')[0]         # report_who : 신고자
        report_id = report[i].split(' ')[1]          # report_id : 신고 대상 id

        for j in range(len(id_list)):
            if report_id == id_list[j]:                # 신고 대상 id와 id_list 가 같으면
                if report_who not in report_list[j]:    # 신고자가 최초 신고자면
                    report_list[j].append(report_who)   # 신고자 이름 기록
                    id_count[j] += 1                    # 신고 횟수 1 누적

    # k번 이상으로 정지된 아이디를 신고해서 메일 받아야 하는 사람 반환
    list_mail = []
    for i in range(len(id_list)):
        if id_count[i] >= k:
            list_mail = list_mail + report_list[i]

    # print(type(list_mail[0]))
    # 메일 횟수 count
    for i in range(len(list_mail)):
        index = id_list.index(list_mail[i])             # list_mail[i]에 해당하는 index 찾아서
        id_mail[index] += 1                             # id_mail 1 증가

    answer = id_mail

    return answer

answer = solution(id_list, report, k)
print(answer)