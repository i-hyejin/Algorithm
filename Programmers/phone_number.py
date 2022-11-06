phone_book = ["12","123","1235","567","88"]

def solution(phone_book):
    answer = True

    phone_book.sort()                           # 양옆을 비교하므로 정렬 후 비교
    for i in range(len(phone_book) - 1):
        if phone_book[i] == phone_book[i+1][:len(phone_book[i])]:
            answer = False

    return answer

print(solution(phone_book))