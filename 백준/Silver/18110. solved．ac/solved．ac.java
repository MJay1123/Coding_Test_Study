import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int size = pq.size();
        int pass = (int)Math.round((double)pq.size()/100*15);
        for(int i=0; i<pass; i++){
            pq.poll();
        }
        int sum = 0;
        while(pq.size() > pass){
            sum += pq.poll();
        }
        int answer = (int)Math.round((double)sum/(size-2*pass));
        bw.write(answer + "\n");
        bw.flush();
    }
}
