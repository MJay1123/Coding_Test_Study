import java.util.*;
import java.io.*;

public class Solution {
    static int N, A;
    static int TEMP = 20171109;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> smallQueue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> largeQueue = new PriorityQueue<>();
            int middle = A;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                if(num < middle){
                    smallQueue.offer(num);
                } else {
                    largeQueue.offer(num);
                }
                num = Integer.parseInt(st.nextToken());
                if(num < middle){
                    smallQueue.offer(num);
                } else {
                    largeQueue.offer(num);
                }
                if(smallQueue.size() > largeQueue.size()){
                    largeQueue.offer(middle);
                    middle = smallQueue.poll();
                } else if(smallQueue.size() < largeQueue.size()){
                    smallQueue.offer(middle);
                    middle = largeQueue.poll();
                }
                answer = (answer + middle) % TEMP;   
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}