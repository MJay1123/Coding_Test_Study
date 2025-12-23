def solution(wallpaper):
    answer = []
    answer.append(len(wallpaper))
    answer.append(len(wallpaper[0]))
    answer.append(0)
    answer.append(0)
    for r in range(len(wallpaper)):
        for c in range(len(wallpaper[0])):
            if wallpaper[r][c] == "#":
                answer[0] = min(answer[0], r)
                answer[1] = min(answer[1], c)
                answer[2] = max(answer[2], r+1)
                answer[3] = max(answer[3], c+1)
    return answer