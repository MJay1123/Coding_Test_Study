def solution(keymap, targets):
    answer = [0] * len(targets)
    arr = [101] * 26
    for i in range(len(keymap)):
        for j in range(len(keymap[i])):
            index = ord(keymap[i][j]) - ord('A')
            arr[index] = min(arr[index], j+1)
    for i in range(len(targets)):
        for j in range(len(targets[i])):
            index = ord(targets[i][j]) - ord('A')
            if arr[index] > 100:
                answer[i] = -1
                break
            answer[i] += arr[index]
    return answer