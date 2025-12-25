def solution(cards1, cards2, goal):
    possible = True
    index = [0] * 3
    while index[2] < len(goal):
        if index[0] < len(cards1) and cards1[index[0]] == goal[index[2]]:
            index[0] += 1
            index[2] += 1
            continue
        if index[1] < len(cards2) and cards2[index[1]] == goal[index[2]]:
            index[1] += 1
            index[2] += 1
            continue
        possible = False
        break
    if possible:
        return "Yes"
    else:
        return "No"