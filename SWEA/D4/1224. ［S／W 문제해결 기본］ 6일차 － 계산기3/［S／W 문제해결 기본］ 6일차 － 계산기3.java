import java.util.*;
import java.io.*;
public class Solution {
    static int length;
    static String str;
    static List<Stack<Integer>> nsl;	// number stack list
    static List<Stack<Character>> csl;	// calculation stack list
    static int index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=10; tc++){
            length = Integer.parseInt(br.readLine());
            str = br.readLine();
            nsl = new ArrayList<>();
            csl = new ArrayList<>();
            nsl.add(new Stack<>());
            csl.add(new Stack<>());
            index = 0;
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                Stack<Integer> ns = nsl.get(index);		// number stack
                Stack<Character> cs = csl.get(index);	// calculation stack
                if(ch == '('){
                    nsl.add(new Stack<>());
                    csl.add(new Stack<>());
                    index++;
                } else if(ch == ')'){
                    while(!cs.isEmpty()){
                        int num2 = ns.pop();
                        int num1 = ns.pop();
                        char calc = cs.pop();
         				ns.push(calculate(num1, num2, calc));
                    }
					int result = ns.pop();
                    nsl.remove(index);
                    csl.remove(index);
                    index--;
                    addNumber(result);
                } else if(ch == '*' || ch == '+'){
                    cs.push(ch);
                } else {
                    int num2 = ch - '0';
                    addNumber(num2);
                }
            }
            int answer = nsl.get(0).peek();
            sb.append(String.format("#%d %d\n", tc, answer));
        }
        bw.write(sb.toString());
        bw.flush();
    }
    
    public static void addNumber(int num2) {
    	Stack<Integer> ns = nsl.get(index);
    	Stack<Character> cs = csl.get(index);
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