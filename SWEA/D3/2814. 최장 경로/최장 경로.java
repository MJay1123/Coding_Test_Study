import java.util.*;
import java.io.*;

class Solution {
    static int max = 0;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());		// 정점
            int M = Integer.parseInt(st.nextToken());		// 간선
            boolean[][] connection = new boolean[N+1][N+1];
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                connection[num1][num2] = true;
                connection[num2][num1] = true;
            }
            boolean[] visited = new boolean[N+1];
            for(int start=1; start<=N; start++){
                DFS(start, connection, visited, 1);
            }
            int answer = max;
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
    
    public static void DFS(int num, boolean[][] arr, boolean[] visited, int depth){
        max = Math.max(max, depth);
        visited[num] = true;
        for(int i=1; i<visited.length; i++){
            if(arr[num][i] && !visited[i]){
                DFS(i, arr, visited, depth+1);
            }
        }
        visited[num] = false;
    }
}