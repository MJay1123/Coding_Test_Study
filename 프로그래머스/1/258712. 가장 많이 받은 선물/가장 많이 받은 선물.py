def solution(friends, gifts):
    f = len(friends)
    friendsDictionary = {friends[index] : index for index in range(f)}
    print(friendsDictionary)
    giftScore = [0] * f
    giftNumber = [[0] * f for r in range(f)]
    giftCount = [0] * f
    for gift in gifts:
        temp = gift.split(" ")
        giveIndex = friendsDictionary.get(temp[0])
        receiveIndex = friendsDictionary.get(temp[1])
        giftNumber[giveIndex][receiveIndex] += 1
        giftScore[giveIndex] += 1
        giftScore[receiveIndex] -= 1
    for i in range(f):
        for j in range(f):
            if i == j:
                continue
            if giftNumber[i][j] > giftNumber[j][i]:
                giftCount[i] += 1
            elif giftNumber[i][j] == giftNumber[j][i] and giftScore[i] > giftScore[j]:
                giftCount[i] += 1
    answer = max(giftCount)
    return answer