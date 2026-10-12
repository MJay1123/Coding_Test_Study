import java.util.*;
import java.io.*;
class Solution {
    static int N, M;
    static List<Integer>[] connections;
    static class Road implements Comparable<Road> {
        int num1;
        int num2;
        int cost;
        public Road(int num1, int num2, int cost){
            this.num1 = num1;
            this.num2 = num2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Road r){
            return this.cost - r.cost;
        }
    }
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            connections = new List[N+1];
            for(int i=1; i<=N; i++){
                connections[i] = new ArrayList<>();
            }
            PriorityQueue<Road> pq = new PriorityQueue<>();
            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                pq.offer(new Road(s, e, c));
            }
            int roadCount = 0;
            int answer = 0;
            parents = new int[N+1];
            for(int i=1; i<=N; i++){
                parents[i] = i;
            }
            while(!pq.isEmpty()){
                if(roadCount == N-1){
                    break;
                }
                Road r = pq.poll();
                int n1 = r.num1;
                int n2 = r.num2;
                if(union(n1, n2)){
                    answer += r.cost;
                    roadCount++;
                }   
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
    static int[] parents;
    static boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2){
            return false;
        } else {
            parents[p2] = p1;
            return true;
        }
    }
    static int find(int num){
        if(parents[num] != num){
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }
}