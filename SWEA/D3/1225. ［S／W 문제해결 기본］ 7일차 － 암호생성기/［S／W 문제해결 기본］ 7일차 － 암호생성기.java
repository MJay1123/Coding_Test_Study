import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int t=1; t<=10; t++){
            int testNumber = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            queue = new LinkedList<>();
            for(int i=0; i<8; i++){
                int input = Integer.parseInt(st.nextToken());
                queue.add(input);
            }
            boolean repeat = true;
            while(repeat){
                for(int i=1; i<=5; i++){
                    int num = queue.poll();
                    num -= i;
                    if(num <= 0){
                        num = 0;
                        queue.offer(num);
                        repeat = false;
                        break;
                    } else {
                        queue.offer(num);
                    }
                }
            }
            bw.write("#" + testNumber + " ");
            for(int i=0; i<8; i++){
                bw.write(queue.poll() + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
