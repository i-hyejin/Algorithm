s = 'abcabcdede'

def solution(s):
    compare_min = len(s)                                # 최소값

    for length in range(1, len(s)):                     # 1부터 문자열 개수만큼 자르기
        # 1. 배열 잘라서 temp에 넣기
        temp = []                                       # 임시 배열
        for j in range(0, len(s), length):
            temp.append(s[j:j+length])

        # 2. 비교 문자열과 반복 횟수 구하기
        compare_string = temp[0]                        # 비교 문자열 (초기값은 첫 번째 문자로)
        compare_count = 1                               # 반복 횟수 (초기값은 1로)
        compare_list = []                               # 개수와 문자열 추가
        for k in range(1, len(temp)):
            if compare_string == temp[k]:               # 같은 경우
                compare_count += 1                      # count 1 증가
            else:                                       # 다른 경우
                if compare_count == 1:                  # count가 1인 경우
                    compare_list.append(compare_string) # compare_string 한 번 정답에 추가
                else:                                   # count가 2 이상인 경우
                    compare_list.append(str(compare_count) + compare_string)
                    compare_count = 1
                                                        # compare_count와 compare_string 한 번 정답에 추가
                compare_string = temp[k]                # 비교 문자열 바꾸기
        if compare_count == 1:  # count가 1인 경우
            compare_list.append(compare_string)  # compare_string 한 번 정답에 추가
        else:  # count가 2 이상인 경우
            compare_list.append(str(compare_count) + compare_string)

        # 3. 전체 문자열 수에서 최소값 구하기
        final_string = ''.join(compare_list)
        if compare_min > len(final_string):
            compare_min = len(final_string)

    return compare_min

print(solution(s))