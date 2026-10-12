import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static List<Integer>[] connections;
    static int answer;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine());
            connections = new List[N+1];
            for(int i=1; i<=N; i++){
                connections[i] = new ArrayList<>();
            }
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                connections[a].add(b);
                connections[b].add(a);
            }
            int[] visited = new int[N+1];
            answer = 0;
            DFS(0, 1, 1, visited);
            sb.append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
    public static void DFS(int prev, int current, int length, int[] visited){
        if(answer != 0){
            return;
        }
        if(visited[current] != 0){
            answer = length - visited[current];
            return;
        }
        visited[current] = length;
        for(int next : connections[current]){
            if(prev == next){
                continue;
            }
            DFS(current, next, length+1, visited);
        }
    }
}