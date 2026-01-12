def solution(ingredient):
    answer = 0
    arr = []
    for i in range(len(ingredient)):
        if len(arr) == 0:
            arr.append(ingredient[i])
        else:
            if arr[len(arr)-1] == 1 and ingredient[i] == 2:
                arr.pop()
                arr.append(12)
            elif arr[len(arr)-1] == 12 and ingredient[i] == 3:
                arr.pop()
                arr.append(123)
            elif arr[len(arr)-1] == 123 and ingredient[i] == 1:
                arr.pop()
                answer += 1
            else:
                arr.append(ingredient[i])
    return answer