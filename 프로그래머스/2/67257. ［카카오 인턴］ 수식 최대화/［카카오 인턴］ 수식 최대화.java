import java.util.*;
class Solution {
    static int[][] priority = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};    // 0 : +, 1 : -, 2 : *
    static char[] calculation = {'+', '-', '*'};
    static List<Long> numberList = new ArrayList<>();
    static List<Character> calcList = new ArrayList<>();
    public long solution(String expression) {
        long answer = 0;
        String[] numberArray = expression.split("\\+|\\-|\\*");
        List<Long> firstNumberList = new ArrayList<>();
        List<Character> firstCalcList = new ArrayList<>();
        for(int i=0; i<numberArray.length; i++){
            firstNumberList.add(Long.parseLong(numberArray[i]));
        }
        for(int i=0; i<expression.length(); i++){
            if(!(expression.charAt(i) >= '0' && expression.charAt(i) <= '9')){
                firstCalcList.add(expression.charAt(i));
            }
        }
        for(int c=0; c<6; c++){
            numberList = firstNumberList;
            calcList = firstCalcList;
            for(int depth = 0; depth<3; depth++){
                char priorityCalculation = calculation[priority[c][depth]];
                process(priorityCalculation, depth);
            }
            answer = Math.max(answer, Math.abs(numberList.get(0)));
        }
        return answer;
    }
    public void process(char priorityCalc, int depth){
        List<Long> tempNumberList = new ArrayList<>();
        List<Character> tempCalcList = new ArrayList<>();
        long left = 0;
        long right = numberList.get(0);
        for(int i=0; i<calcList.size(); i++){
            left = right;
            right = numberList.get(i+1);
            char calc = calcList.get(i);
            if(calc == priorityCalc){
                right = calculate(left, right, calc);
            } else {
                tempNumberList.add(left);
                tempCalcList.add(calc);
            }
        }
        tempNumberList.add(right);
        numberList = tempNumberList;
        calcList = tempCalcList;
    }
    public long calculate(long num1, long num2, char calc){
        switch(calc){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return 0;
    }
}
