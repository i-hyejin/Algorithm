fees = [180, 5000, 10, 600]
records = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]

import math

def timeTominutes(time):
    h, m = map(int, time.split(':'))                        # : 기준으로 시, 분 나누기
    return h * 60 + m

def solution(fees, records):
    answer = []

    dt, df, ut, uf = fees                                   # 기본 시간, 기본 요금, 단위 시간, 단위 요금
    cars = dict()

    for r in records:
        time, number, inout = r.split()                     # record 하나씩 시간, 번호, 출차 정리

        if number in cars:                                  # 이미 들어온 차이면
            cars[number].append([timeTominutes(time), inout])
        else:                                               # 처음 들어온 차이면
            cars[number] = [[timeTominutes(time), inout]]

    cars_list = list(cars.items())                          # number, [time, inout] 순
    cars_list.sort(key=lambda x: x[0])                      # number 기준으로 정렬

    for car in cars_list:
        t = 0                                               # 누적 주차 시간 계산
        for i in car[1]:
            if i[1] == 'IN':                                # in이면 시간 빼기
                t -= i[0]
            else:                                           # out이면 시간 더하기
                t += i[0]

        if car[1][-1][1] == 'IN':                           # 마지막 기록이 IN 이면
            t += timeTominutes('23:59')                     # 23:59 출차로 간주

        if t <= dt:                                         # 누적 주차 시간이 기본 시간 이하라면
            answer.append(df)                               # 기본 요금 청구
        else:                                               # 누적 주차 시간이 기본 시간을 초과하면
            answer.append(df + math.ceil((t-dt) / ut) * uf) # 기본 요금 + 단위 시간마다 단위 요금 청구

    return answer

print(solution(fees, records))