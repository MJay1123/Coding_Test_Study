import java.util.*;
import java.io.*;

class Solution {
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
    static int N;
    static int[][] map;
    static int[][] distances;
	static boolean checkRange(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			distances = new int[N][N];
			int max = N * N * 9;
			for(int r=0; r<N; r++){
                String line = br.readLine();
                for(int c=0; c<N; c++){
                    map[r][c] = line.charAt(c) - '0';
                }
                Arrays.fill(distances[r], max);
            }
            distances[0][0] = 0;
            Queue<Integer> rQueue = new LinkedList<>();
            Queue<Integer> cQueue = new LinkedList<>();
            rQueue.offer(0);
            cQueue.offer(0);
            while(!rQueue.isEmpty()){
                int cr = rQueue.poll();
                int cc = cQueue.poll();
                for(int i=0; i<4; i++){
                    int nr = cr + around[i][0];
                    int nc = cc + around[i][1];
                    if(checkRange(nr, nc) && distances[nr][nc] > distances[cr][cc] + map[nr][nc]){
                        distances[nr][nc] = distances[cr][cc] + map[nr][nc];
                        rQueue.offer(nr);
                        cQueue.offer(nc);
                    }
                }
            }
            int answer = distances[N-1][N-1];
            sb.append(answer).append("\n");
		}
        bw.write(sb.toString());
		bw.flush();
	}
}