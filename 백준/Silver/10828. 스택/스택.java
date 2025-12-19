import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            if(command.equals("pop")){
                if(stack.isEmpty()){
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
            }
            if(command.equals("size")){
                bw.write(stack.size() + "\n");
            }
            if(command.equals("empty")){
                if(stack.isEmpty()){
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }
            if(command.equals("top")){
                if(stack.isEmpty()){
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }
        }
        bw.flush();
    }
}
