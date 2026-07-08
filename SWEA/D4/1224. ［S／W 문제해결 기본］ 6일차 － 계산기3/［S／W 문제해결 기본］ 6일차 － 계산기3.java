import java.util.*;
import java.io.*;
public class Solution {
    static int length;
    static String str;
    static Stack<Stack<Integer>> nss;	// number stack stack
    static Stack<Stack<Character>> css;	// calculation stack stack
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=10; tc++){
            length = Integer.parseInt(br.readLine());
            str = br.readLine();
            nss = new Stack<>();
            css = new Stack<>();
            nss.add(new Stack<>());
            css.add(new Stack<>());
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                Stack<Integer> ns = nss.peek();		// number stack
                Stack<Character> cs = css.peek();	// calculation stack
                if(ch == '('){
                    nss.push(new Stack<>());
                    css.push(new Stack<>());
                } else if(ch == ')'){
                    while(!cs.isEmpty()){
                        int num2 = ns.pop();
                        int num1 = ns.pop();
                        char calc = cs.pop();
         				ns.push(calculate(num1, num2, calc));
                    }
					int result = ns.pop();
                    nss.pop();
                    css.pop();
                    addNumber(result);
                } else if(ch == '*' || ch == '+'){
                    cs.push(ch);
                } else {
                    int num2 = ch - '0';
                    addNumber(num2);
                }
            }
            int answer = nss.peek().peek();
            sb.append(String.format("#%d %d\n", tc, answer));
        }
        bw.write(sb.toString());
        bw.flush();
    }
    
    public static void addNumber(int num2) {
    	Stack<Integer> ns = nss.peek();
    	Stack<Character> cs = css.peek();
    	if(cs.isEmpty()){
            ns.push(num2);
        } else if(cs.peek() == '*'){
            int num1 = ns.pop();
            ns.push(calculate(num1, num2, cs.pop()));
        } else {
            ns.push(num2);
        }
    }
    
    public static int calculate(int num1, int num2, char calc){
        if(calc == '+'){
            return num1 + num2;    
        } else {
			return num1 * num2;
        }
    }
}