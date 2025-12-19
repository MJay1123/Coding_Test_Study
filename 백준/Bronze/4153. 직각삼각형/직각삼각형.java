
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=1; i<=3; i++){
                int num = Integer.parseInt(st.nextToken());
                pq.offer(num);
            }
            int a = pq.poll();
            int b = pq.poll();
            int c = pq.poll();
            if(a == 0 && b == 0 && c == 0){
                break;
            }
            if(a * a + b * b == c * c){
                bw.write("right" + "\n");
            } else {
                bw.write("wrong" + "\n");
            }
        }
        bw.flush();
    }
}
