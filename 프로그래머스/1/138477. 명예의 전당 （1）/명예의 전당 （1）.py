def solution(k, score):
    answer = []
    top = []
    index = 0
    
    while len(top) < k:
        if index == len(score):
            break
        top.append(score[index])
        top.sort()
        answer.append(top[0])
        index += 1
    
    while index < len(score):
        if score[index] > top[0]:
            top.remove(top[0])
            top.append(score[index])
            top.sort()
        answer.append(top[0])
        index += 1
    
    return answer