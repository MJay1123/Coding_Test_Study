def solution(s):
    answer = 0
    
    def cut(s, start):
        count1 = 1
        count2 = 0
        target = s[start]
        for i in range(start+1, len(s)):
            if s[i] == target:
                count1 += 1
            else:
                count2 += 1
            if count1 == count2:
                return i
        return len(s)-1
    
    start = end = 0
    while True:
        if start == len(s):
            break
        end = cut(s, start)
        answer += 1
        start = end + 1
        
    return answer