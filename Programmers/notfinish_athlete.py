participant = ["mislav", "stanko", "mislav", "ana"]
completion = ["stanko", "mislav", "mislav"]

def solution(participant, completion):

    participant.sort()                          # 참가자 정렬
    completion.sort()                           # 완주자 정렬
    for i in range(len(participant)):
        if participant[i] != completion[i]:     # 참가자와 완주자가 다르면
            return participant[i]               # 해당 참가자가 미완주자

print(solution(participant, completion))