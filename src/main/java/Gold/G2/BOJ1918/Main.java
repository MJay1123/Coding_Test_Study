package Gold.G2.BOJ1918;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String equation = br.readLine();
        bw.write(change(equationToList(equation)));
        bw.flush();
    }

    public static List<String> equationToList(String str){
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(ch + "");
            } else if(ch == ')'){
                List<String> temp = new ArrayList<>();
                while(true){
                    String s = stack.pop();
                    if(s.equals("(")){
                        break;
                    }
                    temp.add(0, s);
                }
                result.add(change(temp));
            } else {
                if(stack.isEmpty()) {
                    result.add(ch + "");
                } else {
                    stack.push(ch + "");
                }
            }

        }
        return result;
    }
    public static String change(List<String> list){
        List<String> numList = new LinkedList<>();
        List<String> calcList = new LinkedList<>();
        for(int i=0; i<list.size(); i++){
            String s = list.get(i);
            if(s.equals("+") || s.equals("-")){
                calcList.add(s);
            } else if(s.equals("*") || s.equals("/")){
                String calc = s;
                i++;
                String num2 = list.get(i);
                String num1 = numList.get(numList.size()-1);
                String result = num1 + num2 + calc;
                numList.set(numList.size()-1, result);
            } else {
                numList.add(s);
            }
        }
        String result = "";
        result += numList.get(0);
        for(int i=0; i<calcList.size(); i++){
            result += numList.get(i+1);
            result += calcList.get(i);
        }
        return result;
    }
}
