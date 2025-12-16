def solution(name, yearning, photo):
    answer = [0] * len(photo)
    for r in range(len(photo)):
        for c in range(len(photo[r])):
            for i in range(len(name)):
                if(photo[r][c] == name[i]):
                    answer[r] += yearning[i]
    return answer