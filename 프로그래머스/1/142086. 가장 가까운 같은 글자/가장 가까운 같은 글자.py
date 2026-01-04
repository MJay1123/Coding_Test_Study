def solution(s):
    answer = []
    arr = [-1] * 26
    for i in range(len(s)):
        index = ord(s[i]) - ord('a')
        if arr[index] == -1:
            answer.append(-1)
        else:
            answer.append(i-arr[index])
        arr[index] = i
    return answer