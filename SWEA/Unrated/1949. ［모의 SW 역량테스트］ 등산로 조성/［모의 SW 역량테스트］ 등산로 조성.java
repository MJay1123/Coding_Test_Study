import java.util.*;
import java.io.*;
 
public class Solution {
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer>[] locations;
	static int[][] around = {{1,0},{0,1},{-1,0},{0,-1}};
	static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            locations = new List[21];
            for(int i=1; i<=20; i++) {
            	locations[i] = new ArrayList<>();
            }
            for(int r=0; r<N; r++) {
            	st = new StringTokenizer(br.readLine());
            	for(int c=0; c<N; c++) {
            		map[r][c] = Integer.parseInt(st.nextToken());
            		locations[map[r][c]].add(10 * r + c);
            	}
            }
            int maxHeight = 0;
            for(int i=20; i>=1; i--) {
            	if(locations[i].size() > 0) {
            		maxHeight = i;
            		break;
            	}
            }
            answer = 0;
            for(int loc : locations[maxHeight]) {
            	int r = loc / 10;
            	int c = loc % 10;
            	visited = new boolean[N][N];
            	visited[r][c] = true;
            	DFS(r, c, false, map[r][c], 1);
            }            
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void DFS(int r, int c, boolean dig, int height, int dist) {
    	answer = Math.max(answer,  dist);
    	for(int i=0; i<4; i++) {
    		int nr = r + around[i][0];
    		int nc = c + around[i][1];
			if(checkRange(nr, nc) && !visited[nr][nc]) {
				if(map[nr][nc] < height) {
					visited[nr][nc] = true;
					DFS(nr, nc, dig, map[nr][nc], dist + 1);
					visited[nr][nc] = false;
				} else {
    				if(!dig && map[nr][nc] - K < height) {
    					visited[nr][nc] = true;
    					DFS(nr, nc, true, height - 1, dist + 1);
    					visited[nr][nc] = false;
    				}
				}
			}
    	}
    }
    public static boolean checkRange(int r, int c) {
    	return r >= 0 && r < N && c >= 0 && c < N;
    }
}