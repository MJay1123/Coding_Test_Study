def solution(data, ext, val_ext, sort_by):
    extArray = ["code", "date", "maximum", "remain"]
    index = 0
    for i in range(4) :
        if ext == extArray[i] :
            index = i
    
    indexList = []
    for i in range(len(data)) :
        if data[i][index] < val_ext :
            indexList.append(i)
    
    for i in range(4) :
        if sort_by == extArray[i] :
            index = i
            
    sortList = []
    for i in range(len(indexList)) :
        sortList.append(data[indexList[i]][index])
    
    sortList.sort()
    
    list = []
    for i in range(len(sortList)) :
        for j in range(len(indexList)) :
            if data[indexList[j]][index] == sortList[i] :
                list.append(indexList[j])
    
    answer = [[0] * len(data[0]) for _ in range(len(list))]
    for i in range(len(sortList)) :
        for j in range(len(indexList)) :
            if data[indexList[j]][index] == sortList[i] :
                for k in range(len(data[0])) :
                    answer[i][k] = data[indexList[j]][k]

    return answer
