import java.util.*;
import java.io.*;
public class Solution {
	static int N, M, R, C, L;
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] connection = {{}, {0,1,2,3},{0,2},{1,3},{1,2},{0,1},{0,3},{2,3}};
    static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = BFS(R, C);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
    public static int BFS(int startR, int startC){
        int count = 0;
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        Queue<Integer> distQueue = new LinkedList<>();
        rQueue.offer(startR);
        cQueue.offer(startC);
        distQueue.offer(1);
        visited[startR][startC] = true;
        count++;
        while(!rQueue.isEmpty()){
            int r = rQueue.poll();
            int c = cQueue.poll();
            int dist = distQueue.poll();
            int pipeType = map[r][c];
            int[] directions = connection[pipeType];
            for(int i=0; i<directions.length; i++){
                int direction = directions[i];
                int nr = r + around[direction][0];
                int nc = c + around[direction][1];
             	if(checkRange(nr, nc) && !visited[nr][nc] && map[nr][nc] > 0 && dist + 1 <= L && canConnected(direction, map[nr][nc])){
                    rQueue.offer(nr);
                    cQueue.offer(nc);
                    distQueue.offer(dist + 1);
                    visited[nr][nc] = true;
                    count++;
                }
            }
        }
        return count;
    }
	public static boolean canConnected(int direction, int nextPipe){
        if(nextPipe == 1){
            return true;
        }
        int[][] arr = {{2,4,7},{3,6,7},{2,5,6},{3,4,5}};
        for(int pipe : arr[direction]){
            if(nextPipe == pipe){
                return true;
            }
        }
        return false;
    }
    public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
