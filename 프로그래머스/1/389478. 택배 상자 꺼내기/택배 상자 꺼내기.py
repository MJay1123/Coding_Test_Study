def solution(n, w, num):
    answer = 0
    h = (n-1) // w + 1
    array = [[0] * w for c in range(h)]
    number = 1
    for i in range(1 , h+1):
        r = h - i
        if i % 2 == 1:  # 정방향
            for c in range(w):
                array[r][c] = number
                if number == num:
                    numR = r
                    numC = c
                number += 1
        else :          # 역방향
            for c in range(w-1, -1, -1):
                array[r][c] = number
                if number == num:
                    numR = r
                    numC = c
                number += 1
    for r in range(numR+1):
        if array[r][numC] > n:
            continue;
        answer += 1
    return answer