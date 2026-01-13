T = int(input())

def check(number):
    index = [-1] * 10
    for i in range(len(number)):
        num = int(number[i])    
        if index[num] == -2:
            return False
        if index[num] == -1:
            index[num] = i
        else:
            if i - index[num] == num + 1:
                index[num] = -2
            else:
                return False
    for i in range(10):
        if index[i] >= 0:
            return False
    return True
    
for test_case in range(1, T + 1):
    number = input()
    if check(number):
        print('yes')
    else:
        print('no')
    
            