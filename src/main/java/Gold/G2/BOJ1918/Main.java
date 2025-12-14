package Gold.G2.BOJ1918;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String equation = br.readLine();
        int bracketCount = 0;
        for(int i=0; i<equation.length(); i++){
            if(equation.charAt(i) == '('){
                bracketCount++;
            }
        }
        String[][] arr = new String[bracketCount+1][equation.length()];
        int index = 0;
        for(int i=0; i<equation.length(); i++){
            char ch = equation.charAt(i);
            if(ch == '('){
                index++;
                arr[index][i] = ch + "";
            } else if(ch == ')') {
                arr[index][i] = ch + "";
                index--;
            } else {
                arr[index][i] = ch + "";
            }
        }
        for(int r=bracketCount; r>0; r--){
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();
            for(int c=0; c<equation.length(); c++){
                if(arr[r][c] == null){
                    continue;
                }
                if(arr[r][c].equals("(")) {
                    leftList.add(c);
                }
                if(arr[r][c].equals(")")){
                    rightList.add(c);
                }
            }
            for(int i=0; i<leftList.size(); i++){
                int left = leftList.get(i);
                int right = rightList.get(i);
                String[] temp = new String[right-left-1];
                for(int j=0; j<temp.length; j++){
                    temp[j] = arr[r][left+1+j];
                }
                String result = change(temp);
                arr[r-1][left] = result;
            }
        }
        bw.write(change(arr[0]));
        bw.flush();
    }

    public static String change(String[] arr){
        List<String> numList = new LinkedList<>();
        List<String> calcList = new LinkedList<>();
        for(int i=0; i<arr.length; i++){
            String s = arr[i];
            if(s == null){
                continue;
            }
            if(s.equals("+") || s.equals("-")){
                calcList.add(s);
            } else if(s.equals("*") || s.equals("/")){
                i++;
                while(arr[i] == null){
                    i++;
                }
                String num2 = arr[i];
                String num1 = numList.get(numList.size()-1);
                String result = num1 + num2 + s;
                numList.set(numList.size()-1, result);
            } else {
                numList.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(numList.get(0));
        for(int i=0; i<calcList.size(); i++){
            sb.append(numList.get(i+1));
            sb.append(calcList.get(i));
        }
        return sb.toString();
    }
}
