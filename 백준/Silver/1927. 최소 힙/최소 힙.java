

import java.io.*;
import java.util.*;

// 최소 힙
public class Main {
    static int N;           // 연산의 개수
    static List<Long> list = new LinkedList<Long>();
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(queue.isEmpty()){
                    bw.write(0 + "\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            } else {
                queue.add(num);
            }
        }
        bw.flush();
    }
}
