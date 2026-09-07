import java.util.*;
import java.io.*;
class Solution {
    static int V, E;
    static int[] parents;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parents = new int[V+1];
            for(int i=1; i<=V; i++){
                parents[i] = -1;
            }
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
				pq.offer(new Edge(A, B, C));
            }
            long answer = 0;
            int count = 0;
            while(!pq.isEmpty()){
                if(count == E-1){
                    break;
                }
                Edge e = pq.poll();
                int n1 = e.num1;
                int n2 = e.num2;
                if(union(n1, n2)){
                    answer += e.weight;
                    count++;
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
    public static boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 != p2){
            if(parents[p1] > parents[p2]){
                parents[p1] = p2;
            } else if(parents[p1] < parents[p2]) {
                parents[p2] = p1;
            } else {
                parents[p1] = p2;
                parents[p2]--;
            }
            return true;
        }
        return false;
    }
    public static int find(int n){
        if(parents[n] > 0){
            return find(parents[n]);
        }
        return n;
    }
    static class Edge implements Comparable<Edge> {
        int num1;
        int num2;
        int weight;
        public Edge(int num1, int num2, int weight){
            this.num1 = num1;
            this.num2 = num2;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
}