def solution(grid):
    directions = [[1,0],[0,1],[-1,0],[0,-1]]
    rLen = len(grid)
    cLen = len(grid[0])
    gridMap = [[""] * cLen for r in range(rLen)]
    for r in range(rLen):
        for c in range(cLen):
            gridMap[r][c] = grid[r][c]
    visited = [[[False] * 4 for _ in range(cLen)] for _ in range(rLen)]
    
    class Light:
        def __init__(self, r, c, direction):
            self.r = r
            self.c = c
            self.direction = direction
    
    def DFS(light, gridMap, visited):
        r = light.r
        c = light.c
        direction = light.direction
        visited[r][c][direction] = True
        depth = 1
        while True:
            nr = (r + directions[direction][0] + rLen) % rLen
            nc = (c + directions[direction][1] + cLen) % cLen
            if gridMap[nr][nc] == "S":
                nextDirection = direction
            elif gridMap[nr][nc] == "L":
                nextDirection = (direction + 1) % 4
            else:
                nextDirection = (direction + 3) % 4
            
            if not visited[nr][nc][nextDirection]:
                visited[nr][nc][nextDirection] = True
                depth += 1
                r = nr
                c = nc
                direction = nextDirection
            else:
                break
        
        return depth
    
    answer = []
    for r in range(rLen):
        for c in range(cLen):
            for d in range(4):
                if not visited[r][c][d]:
                    light = Light(r, c, d)
                    answer.append(DFS(light, gridMap, visited))
                    
    answer.sort()
    return answer