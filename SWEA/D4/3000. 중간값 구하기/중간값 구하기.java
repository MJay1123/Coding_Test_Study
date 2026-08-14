import java.util.*;
import java.io.*;

public class Solution {
    static int N, A;
    static int TEMP = 20171109;
    static PriorityQueue<Integer> sq = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> lq = new PriorityQueue<>();
    static int middle;
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
            sq.clear();
            lq.clear();
            middle = A;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                write(num);
                num = Integer.parseInt(st.nextToken());
                write(num);
                sort();
                answer = (answer + middle) % TEMP;   
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void write(int num){
        if(num < middle){
            sq.offer(num);
        } else {
            lq.offer(num);
        }
    }
    public static void sort(){
        if(sq.size() > lq.size()){
            lq.offer(middle);
            middle = sq.poll();
        } else if(sq.size() < lq.size()){
            sq.offer(middle);
            middle = lq.poll();
        }
    }
}