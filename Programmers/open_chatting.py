record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]

def solution(record):
    answer = []

    # record 자르기
    record_pre = []                                                         # 자른 record 저장할 곳
    for i in range(len(record)):
        record_pre.append(record[i].split(' '))                             # 띄어쓰기 단위로 자르기

    # dict에 (id: name) 저장하기
    record_dict = {}                                                        # record의 (id: anme) 저장할 곳
    for i in range(len(record_pre)):
        if record_pre[i][0] == 'Enter' or record_pre[i][0] == 'Change':     # Enter거나 Change이면
            record_dict[record_pre[i][1]] = record_pre[i][2]                # dict에 (uid, name) 쌍 추가

    # 문구 출력하기
    for i in range(len(record_pre)):
        name = record_dict[record_pre[i][1]]
        if record_pre[i][0] == 'Enter':
            answer.append(name + '님이 들어왔습니다.')
        if record_pre[i][0] == 'Leave':
            answer.append(name + '님이 나갔습니다.')

    return answer

print(solution(record))