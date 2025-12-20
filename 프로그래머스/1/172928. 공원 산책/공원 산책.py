def solution(park, routes):
    for r in range(len(park)):
        for c in range(len(park[0])):
            if park[r][c] == "S":
                locR = r
                locC = c
    def checkRange(r, c, park):
        return r >= 0 and r < len(park) and c >= 0 and c < len(park[0])
    
    arr = {'N' : [-1,0], 'S' : [1,0], 'E' : [0,1], 'W' : [0,-1]}
    def move(r, c, direction, distance, park):
        nr = r
        nc = c
        for i in range(distance):
            nr += arr.get(direction)[0]
            nc += arr.get(direction)[1]
            if not checkRange(nr, nc, park) or park[nr][nc] == 'X':
                return r, c
        return nr, nc
        
    for route in routes:
        direction = route[0]
        distance = int(route[2:])
        locR, locC = move(locR, locC, direction, distance, park)
    answer = [locR, locC]
    return answer