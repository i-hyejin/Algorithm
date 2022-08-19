w = 8
h = 12

def gcd(a, b):                                  # 최대공약수 함수
    if a % b == 0:                              # a를 b로 나눌 수 없으면
        return b                                # b return
    else:
        return gcd(b, a % b)                    # b와 a % b 의 최대공약수 찾기

def solution(w, h):
    answer = 1

    whole_square = w * h                        # 전체 사각형의 개수
    broken_square = w + h - gcd(w, h)           # 부러진 사각형의 개수
    answer = whole_square - broken_square

    return answer

print(solution(w, h))