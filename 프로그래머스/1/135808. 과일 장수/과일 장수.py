def solution(k, m, score):
    arr = list(score)
    arr.sort()
    answer = 0
    while len(arr) >= m:
        for i in range(m-1):
            arr.pop()
        answer += (arr.pop() * m)
    return answer