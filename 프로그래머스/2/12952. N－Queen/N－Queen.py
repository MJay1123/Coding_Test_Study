def solution(n):
    columns = [False] * n
    diagonal1 = [False] * (2*n-1)   # r+c
    diagonal2 = [False] * (2*n-1)   # r-c+n
    
    def placeInRow(r):
        if r == n:
            return 1
        
        count = 0
        for c in range(n):
            if not columns[c] and not diagonal1[r+c] and not diagonal2[r-c+n-1]:
                columns[c] = diagonal1[r+c] = diagonal2[r-c+n-1] = True
                count += placeInRow(r+1)
                columns[c] = diagonal1[r+c] = diagonal2[r-c+n-1] = False
        return count
    
    answer = placeInRow(0)
    return answer