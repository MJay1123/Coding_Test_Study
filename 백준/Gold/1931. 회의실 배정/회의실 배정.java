import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 회의실 배정
public class Main {
    static int N;                   // 회의 수
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(start, end));
        }
        int time = 0;
        while(!pq.isEmpty()){
            Meeting mt = pq.poll();
            if(mt.start >= time){
                answer++;
                time = mt.end;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end != o.end){
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }
}
