def solution(board, h, w):
    answer = 0
    length = len(board)
    color = board[h][w]
    move = [[1,0],[0,1],[-1,0],[0,-1]]
    count = 0;
    def checkRange(r, c):
        result = r >= 0 and r < length and c >= 0 and c < length
        return result
    for i in range(4) :
        nh = h + move[i][0]
        nw = w + move[i][1]
        if checkRange(nh, nw) :
            if board[nh][nw] == color :
                answer = answer + 1
    return answer

