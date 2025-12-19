def solution(players, m, k):
    answer = 0
    servers = [[0] * 24 for r in range(2)]
    for i in range(24):
        need = (players[i] // m) - servers[0][i]
        if need > 0:
            servers[1][i] += need
            for j in range(k):
                if i+j >= 24:
                    break
                servers[0][i+j] += need
    for i in range(24):
        answer += servers[1][i]
    return answer