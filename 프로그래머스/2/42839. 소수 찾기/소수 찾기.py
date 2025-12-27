import math
def solution(numbers):
    isPrime = [False] * int(math.pow(10, len(numbers)))
    isPrime[0] = isPrime[1] = True
    for i in range(int(math.sqrt(len(isPrime)))):
        if not isPrime[i]:
            j = 2
            while i*j < len(isPrime):
                isPrime[i*j] = True
                j += 1
        
    def getNumber(numbers, visited, result, depth):
        if len(result) == depth:
            sum = 0
            for i in range(len(result)):
                sum += int(math.pow(10, i)) * result[len(result)-1-i]
            if not isPrime[sum]:
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
