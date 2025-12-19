import queue
def solution(storage, requests): 
    map = [[0]*(len(storage[0]) + 2) for r in range(len(storage)+2)]
    for r in range(len(storage)):
        for c in range(len(storage[0])):
            map[r+1][c+1] = storage[r][c]
            
    class Location:
        def __init__(self, r, c):
            self.r = r
            self.c = c
            
    def pickAll(target, map):
        for r in range(len(map)):
            for c in range(len(map[0])):
                if map[r][c] == target:
                    map[r][c] = 0
        return map
                    
    def checkRange(r, c, map):
        return r >= 0 and r < len(map) and c >= 0 and c < len(map[0])
                    
    def bfs(loc, target, map):
        move = [[1,0],[0,1],[-1,0],[0,-1]]
        visited = [[False]*len(map[0]) for r in range(len(map))]
        que = queue.Queue()
        r = loc.r
        c = loc.c
        visited[r][c] = True
        que.put(loc)
        while(que.qsize() > 0):
            loc = que.get()
            r = loc.r
            c = loc.c
            for i in range(4):
                nr = r + move[i][0]
                nc = c + move[i][1]
                if checkRange(nr, nc, map) and visited[nr][nc] == False:
                    if map[nr][nc] == 0:
                        que.put(Location(nr, nc))
                        visited[nr][nc] = True
                    elif map[nr][nc] == target:
                        map[nr][nc] = 0
                        visited[nr][nc] = True
        return map
    
    for request in requests:
        if len(request) == 1:
            map = bfs(Location(0,0), request, map)
        else:
            map = pickAll(request[0], map)
        
    answer = 0
    for r in range(len(map)):
        for c in range(len(map[0])):
            if map[r][c] != 0:
                answer += 1
    return answer