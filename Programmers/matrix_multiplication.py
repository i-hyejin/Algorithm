arr1 = [[1, 4], [3, 2], [4, 1]]
arr2 = [[3, 3], [3, 3]]

def solution(arr1, arr2):
    answer = []

    for i in range(len(arr1)):                          # 첫 번째 배열의 행 만큼 반복
        tmp_list = []
        for j in range(len(arr2[0])):                   # 두 번째 배열의 열 만큼 반복
            tmp = 0
            for k in range(len(arr1[0])):               # 첫 번째 배열의 열 만큼 반복
                tmp += arr1[i][k] * arr2[k][j]          # 각 자리를 곱해서 더하기
            tmp_list.append(tmp)                        # 더한 값을 임시 리스트에 append
        answer.append(tmp_list)                         # 임시 리스트를 정답에 append

    return answer

print(solution(arr1, arr2))