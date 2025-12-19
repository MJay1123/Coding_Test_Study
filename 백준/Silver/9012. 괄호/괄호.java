
import java.io.*;
import java.util.Stack;

// 괄호
public class Main {
    static int T;       // 케이스의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for(int j=0; j<input.length; j++){
                if(stack.isEmpty()){
                    stack.push(input[j]);
                } else {
                    if (input[j].equals(")") && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(input[j]);
                    }
                }
            }
            if(stack.isEmpty()){
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
    }
}
