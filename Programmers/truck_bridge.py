bridge_length = 2
weight = 10
truck_weights = [7,4,5,6]

def solution(bridge_length, weight, truck_weights):
    answer = 0

    truck_bridge = [0] * bridge_length
    while len(truck_bridge):
        answer += 1
        truck_bridge.pop(0)                                         # 트럭 하나 꺼내기
        if truck_weights:
            if sum(truck_bridge) + truck_weights[0] <= weight:      # 다리 위에 있는 트럭의 합이 기준 이하이면
                truck_bridge.append(truck_weights.pop(0))           # 다리 위에 트럭 하나 추가
            else:
                truck_bridge.append(0)                              # 현재 트럭만 추가

    return answer

print(solution(bridge_length, weight, truck_weights))