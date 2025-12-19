import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int result = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++){
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
                pq.offer(num);
            }
            while(!queue.isEmpty()) {
                while (queue.peek() != pq.peek()) {
                    queue.offer(queue.poll());
                    M--;
                    if (M < 0) {
                        M += queue.size();
                    }
                }
                if(M == 0){
                    bw.write(result + "\n");
                    break;
                }
                queue.poll();
                pq.poll();
                M--;
                result++;
            }
        }
        bw.flush();
    }
}
