
import java.io.*;
import java.util.Stack;

// 제로
public class Main {
    static int K;   // 정수의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && !stack.isEmpty()){
                answer -= stack.pop();
            } else {
                answer += stack.push(num);
            }
        }
        
        bw.write(answer + "\n");
        bw.flush();
    }
}
