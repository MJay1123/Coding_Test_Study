def solution(n, k):
    
    def factorial(n):
        if n == 0 or n == 1:
            return 1
        return factorial(n-1) * n;
    
    index = [0] * n
    for i in range(n):
        index[i] = (k-1) // factorial(n-1-i)
        k = k - factorial(n-1-i) * index[i]
    
    numbers = []
    for i in range(n):
        numbers.append(i+1)
    
    answer = [0] * n
    for i in range(n):
        answer[i] = numbers.pop(index[i])

    return answer