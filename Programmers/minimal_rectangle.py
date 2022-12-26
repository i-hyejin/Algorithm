sizes = [[60, 50], [30, 70], [60, 30], [80, 40]]

def solution(sizes):
    answer = 0

    # w_list = []
    # h_list = []
    #
    # for i in range(len(sizes)):
    #     if sizes[i][0] > sizes[i][1]:
    #         w_list.append(sizes[i][0])
    #         h_list.append(sizes[i][1])
    #     else:
    #         w_list.append(sizes[i][1])
    #         h_list.append(sizes[i][0])
    #
    # answer = max(w_list) * max(h_list)

    answer = max(max(w) for w in sizes) * max((min(h) for h in sizes))

    return answer

print(solution(sizes))