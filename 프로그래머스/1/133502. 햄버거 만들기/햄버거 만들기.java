import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<ingredient.length; i++){
            if(stack.isEmpty()){
                stack.push(ingredient[i]);
            } else {
                if(stack.peek() == 1 && ingredient[i] == 2){
                    stack.pop();
                    stack.push(12);
                } else if(stack.peek() == 12 && ingredient[i] == 3){
                    stack.pop();
                    stack.push(123);
                } else if(stack.peek() == 123 && ingredient[i] == 1){
                    stack.pop();
                    answer++;
                } else {
                    stack.push(ingredient[i]);
                }
            }
        }
        return answer;
    }
}