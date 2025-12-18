def solution(expression):
    priorities = [[0,1,2],[0,2,1],[1,0,2],[1,2,0],[2,0,1],[2,1,0]]
    calculation = ['+', '-', '*']
    firstCalcList = [expression[i]
                      for i in range(len(expression))
                      if expression[i] == "+" or expression[i] == "-" or expression[i] == "*"]
    temp = expression
    for op in "+-*":
        temp = temp.replace(op, " ")
    firstNumberList = [int(k) 
                        for k in temp.split(" ") 
                        if k]
    
    def calculate(num1, num2, calc):
        if calc == "+":
            return num1 + num2
        if calc == "-":
            return num1 - num2
        if calc == "*":
            return num1 * num2
        
    def process(numberList, calcList, priorityCalc):
        tempNumberList = []
        tempCalcList = []
        left = 0
        right = numberList[0]
        for i in range(len(calcList)):
            left = right
            right = numberList[i+1]
            calc = calcList[i]
            if calc == priorityCalc:
                right = calculate(left, right, calc)
            else:
                tempNumberList.append(left)
                tempCalcList.append(calc)
        tempNumberList.append(right)
        return tempNumberList, tempCalcList
                
    answer = 0
    for i in range(6):
        numberList = firstNumberList
        calcList = firstCalcList
        for depth in range(3):
            priorityCalc = calculation[priorities[i][depth]]
            numberList, calcList = process(numberList, calcList, priorityCalc)
        answer = max(answer, abs(numberList[0]))
    return answer