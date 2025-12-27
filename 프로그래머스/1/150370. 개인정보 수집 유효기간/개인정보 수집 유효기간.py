def solution(today, terms, privacies):
    def getDate(date):
        return int(date[0:4]) * 12 * 28 + int(date[5:7]) * 28 + int(date[8:10])
    todayDate = getDate(today)
    termsArray = [0] * 26
    for i in range(len(terms)):
        index = ord(terms[i][0:1]) - ord("A")
        term = int(terms[i][2:]) * 28
        termsArray[index] = term
    answer = []
    for i in range(len(privacies)):
        startDate = getDate(privacies[i][0:10])
        index = ord(privacies[i][11]) - ord('A')
        period = termsArray[index]
        if startDate + period <= todayDate:
            answer.append(i+1)
    return answer