import java.util.*;
import java.io.*;
class Solution {
    static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            for(int r=0; r<N; r++){
                String str = br.readLine();
                for(int c=0; c<M; c++){
                    map[r][c] = str.charAt(c);
                }
            }
            visited = new boolean[N][M];
            int answer = 0;
            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    if(map[r][c] == 'L' && !visited[r][c]){
                        answer++;
                        BFS(r, c);
                    }
                }
            }
            sb.append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
    public static boolean checkRange(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    public static void BFS(int sr, int sc){
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        rQueue.offer(sr);
        cQueue.offer(sc);
        visited[sr][sc] = true;
        while(!rQueue.isEmpty()){
            int r = rQueue.poll();
            int c = cQueue.poll();
            for(int i=0; i<4; i++){
                int nr = r + around[i][0];
                int nc = c + around[i][1];
                if(checkRange(nr, nc) && map[nr][nc] == 'L' && !visited[nr][nc]){
                    rQueue.offer(nr);
                    cQueue.offer(nc);
                    visited[nr][nc] = true;
                }
            }
        }
    }
}