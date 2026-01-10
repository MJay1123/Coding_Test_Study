def solution(board):
    answer = 0
    rows, columns = len(board), len(board[0])
    dp = [[0] * columns for _ in range(rows)]
    
    for r in range(rows):
        if board[r][0] == 1:
            dp[r][0] = 1
            answer = 1
            
    for c in range(columns):
        if(board[0][c] == 1):
            dp[0][c] = 1
            answer = 1
    
    for r in range(1, rows):
        for c in range(1, columns):
            if board[r][c] == 1:
                dp[r][c] = min(dp[r-1][c-1], dp[r-1][c], dp[r][c-1]) + 1
                answer = max(answer, dp[r][c]*dp[r][c])
    
    return answer

