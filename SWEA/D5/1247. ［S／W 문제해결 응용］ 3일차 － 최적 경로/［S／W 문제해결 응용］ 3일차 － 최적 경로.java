import java.util.*;
import java.io.*;
public class Solution {
	static int N;
    static int[] company;
    static int[] home;
    static int[][] customers;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
            company = new int[2];
            company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
            home = new int[2];
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
            customers = new int[N][2];
			for(int i=0; i<N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			answer = 200 * (N + 1);
			boolean[] visited = new boolean[N];
			visit(0, company[0], company[1], visited, 0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
    public static void visit(int distance, int x, int y, boolean[] visited, int visitCount){
        if(distance + getDistance(x, y, home[0], home[1]) > answer){
            return;
        }
        if(visitCount == N){
            answer = Math.min(answer, distance + getDistance(x, y, home[0], home[1]));
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                int nx = customers[i][0];
                int ny = customers[i][1];
                visited[i] = true;
                visit(distance+getDistance(x, y, nx, ny), nx, ny, visited, visitCount+1);
                visited[i] = false;
            }
        }
    }
	public static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2); 
	}
}