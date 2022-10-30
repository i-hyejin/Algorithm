n = 5
lost = [2, 4]
reserve = [1, 3, 5]

def solution(n, lost, reserve):
    answer = 0

    _lost = set(lost) - set(reserve)        # 여벌 체육복이 도난 당했을 수 있음
    _reserve = set(reserve) - set(lost)

    for i in _reserve:                      # 여벌 체육복을 기준으로
        if i-1 in _lost:                    # i-1 번째가 lost 이면
            _lost.remove(i-1)               # lost에서 제거
        elif i+1 in _lost:                  # i+1 번째가 lost 이면
            _lost.remove(i+1)               # lost에서 제거

    answer = n - len(_lost)                 # 전체 학생 중에 lost에 남아 있는 수 제거

    return answer