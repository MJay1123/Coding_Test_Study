import math
def solution(numbers):
    isPrime = [True] * 10000000
    isPrime[0] = isPrime[1] = False
    for i in range(int(math.sqrt(10000000))):
        if isPrime[i]:
            j = 2
            while i*j < 10000000:
                isPrime[i*j] = False
                j += 1
        
    def getNumber(numbers, visited, result, depth):
        if len(result) == depth:
            sum = 0
            for i in range(len(result)):
                sum += int(math.pow(10, i)) * result[len(result)-1-i]
            if isPrime[sum]:
                hs.add(sum)
            return
        for i in range(len(numbers)):
            if visited[i]:
                continue
            visited[i] = True
            result.append(int(numbers[i]))
            getNumber(numbers, visited, result, depth)
            visited[i] = False
            result.pop()
    
    hs = set()
    for depth in range(1, len(numbers)+1):
        visited = [False] * len(numbers)
        result = []
        getNumber(numbers, visited, result, depth)
            
    answer = len(hs)
    return answer