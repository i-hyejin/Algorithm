genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]

def solution(genres, plays):
    answer = []
    genres_dict = {x:0 for x in genres}                                                 # 초기화 된 딕셔너리 만들기
    
    # 전체 장르별 재생 수 구하기
    for i in range(len(genres)):
        if genres[i] in genres_dict.keys():                                             # 딕셔너리 key에 장르가 있으면
            genres_dict[genres[i]] += plays[i]                                          # 해당 장르에 재생 수 추가
    genres_dict = dict(sorted(genres_dict.items(), key=lambda x:x[1], reverse=True))    # 재생 수 기준으로 정렬

    # 장르별 재생 수 넣기
    for i in list(genres_dict.keys()):
        temp = []
        for j in range(len(genres)):
            if i == genres[j]:                                                          # 딕셔너리 key와 같은 장르이면
                temp.append((plays[j], j))                                              # temp에 재생 수와 고유 번호 추가
        temp.sort(key=lambda x:(-x[0], x[1]))                                           # 재생 수 내림차순, 고유 번호 오름차순으로 정렬

    # 장르별 상위 2개 곡 고르기
        if len(temp) == 1:                                                              # 곡이 1곡인 경우
            answer.append(temp[0][1])                                                   # 1곡만 추가함
        else:                                                                           # 곡이 2곡 이상인 경우
            answer.append(temp[0][1])                                                   # 2곡을 추가함
            answer.append(temp[1][1])

    return answer

print(solution(genres, plays))