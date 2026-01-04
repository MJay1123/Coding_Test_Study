import math
def solution(relation):
    row_len = len(relation)
    col_len = len(relation[0])
    
    def putIn(columnsSet, num):
        if len(columnsSet) == 0:
            columnsSet.add(num)
        else:
            for i in columnsSet:
                if (i & num) == i or (i & num) == num:
                    num = min(i, num)
                    columnsSet.remove(i)
                    columnsSet.add(num)
            columnsSet.add(num)
                
    columnsSet = []
    
    for i in range(1, 1 << col_len):
        dataSet = set()
        for r in range(row_len):
            data = []
            for c in range(col_len):
                if i & (1 << c):
                    data.append(relation[r][c])
            dataSet.add(tuple(data))
        if len(dataSet) == len(relation):
            columnsSet.append(i)

    columnsSet.sort(key=lambda x: bin(x).count('1'))
    finalKeys = set()
    for i in range(len(columnsSet)):
        is_minimal = True
        for j in range(i):
            if (columnsSet[j] & columnsSet[i]) == columnsSet[j]:
                is_minimal = False
                break
        if is_minimal:
            finalKeys.add(columnsSet[i])
            
    answer = len(finalKeys)
    return answer