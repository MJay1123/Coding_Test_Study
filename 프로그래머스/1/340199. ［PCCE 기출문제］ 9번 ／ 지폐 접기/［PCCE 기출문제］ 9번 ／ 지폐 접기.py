def solution(wallet, bill):
    
    def fold(bill):
        if bill[0] >= bill[1]:
            bill[0] //= 2
        else:
            bill[1] //= 2
    
    def compare(wallet, bill):
        if max(wallet[0], wallet[1]) < max(bill[0], bill[1]):
            return True
        if min(wallet[0], wallet[1]) < min(bill[0], bill[1]):
            return True
        return False
    
    answer = 0
    while compare(wallet, bill):
        fold(bill)
        answer += 1
    return answer