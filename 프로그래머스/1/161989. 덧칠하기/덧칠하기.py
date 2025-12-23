def solution(n, m, section):
    answer = 0
    index = 0
    current = 0
    while current <= n and index < len(section):
        nextPaint = section[index]
        index += 1
        if current <= nextPaint:
            current = nextPaint + m
            answer += 1
    return answer 