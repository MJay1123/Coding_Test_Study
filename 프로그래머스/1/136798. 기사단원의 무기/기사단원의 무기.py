import math
def solution(number, limit, power):
    
    def getDamage(number):
        result = 0
        for i in range(1, int(math.sqrt(number)+1)):
            if number % i == 0:
                if number // i == i:
                    result += 1
                else:
                    result += 2
        return result
    
    answer = 0
    for i in range(1, number+1):
        damage = getDamage(i)
        if damage > limit:
            answer += power
        else:
            answer += damage
    return answer