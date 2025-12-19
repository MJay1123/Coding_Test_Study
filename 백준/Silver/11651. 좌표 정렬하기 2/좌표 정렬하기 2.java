import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static class Location implements Comparable<Location> {
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location o) {
            if(this.y == o.y){
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Location> pq = new PriorityQueue<>();
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Location(x, y));
        }
        while(!pq.isEmpty()){
            Location loc = pq.poll();
            bw.write(loc.x + " " + loc.y + "\n");
        }
        bw.flush();
    }
}
