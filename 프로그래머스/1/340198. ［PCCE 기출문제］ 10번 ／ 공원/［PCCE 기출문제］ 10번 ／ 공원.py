def solution(mats, park):
    
    def checkRange(r, c, park):
        return r >= 0 and c >= 0 and r < len(park) and c < len(park[0])
    
    def check(r, c, park, size):
        for dr in range(size):
            for dc in range(size):
                nr = r + dr
                nc = c + dc
                if(not checkRange(nr, nc, park) or park[nr][nc] != "-1"):
                    return False
        return True
    
    answer = -1
    for i in range(len(mats)):
        size = mats[i]
        for r in range(len(park)):
            for c in range(len(park[0])):
                if(check(r, c, park, size)):
                    answer = max(answer, size)                    

    return answer