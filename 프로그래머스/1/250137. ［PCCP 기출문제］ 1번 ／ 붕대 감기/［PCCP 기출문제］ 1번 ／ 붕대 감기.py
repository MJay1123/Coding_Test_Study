def solution(bandage, health, attacks):
    answer = health
    for i in range(len(attacks) - 1):
        answer -= attacks[i][1]
        if(answer <= 0):
            return -1
        healTime = attacks[i+1][0] - attacks[i][0] - 1
        answer += healTime // bandage[0] * bandage[2]
        answer += healTime * bandage[1]
        if(answer > health):
            answer = health
    answer -= attacks[len(attacks)-1][1]
    if(answer <= 0):
        return -1
    return answer