import java.io.*;
import java.util.*;

public class Main {
    static int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static int[][][] blocks = {
            {{1,0},{0,1},{0,-1}},   // ㅜ
            {{1,0},{0,1},{-1,0}},   // ㅏ
            {{0,1},{0,-1},{-1,0}},  // ㅗ
            {{1,0},{0,-1},{-1,0}}   // ㅓ
    };
    static int answer = 0;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][M];
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                result = arr[r][c];
                visited[r][c] = true;
                DFS(r, c, arr, visited, 1);
                visited[r][c] = false;
                result = 0;
                DFS(r, c, arr);
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void DFS(int r, int c, int[][] arr){
        result = 0;
        for(int i=0; i<blocks.length; i++){
            boolean possible = true;
            result = arr[r][c];
            for(int j=0; j<3; j++){
                int nr = r + blocks[i][j][0];
                int nc = c + blocks[i][j][1];
                if (checkRange(nr, nc, arr)) {
                    result += arr[nr][nc];
                } else {
                    possible = false;
                    break;
                }
            }
            if(possible){
                answer = Math.max(answer, result);
            }
        }
    }

    public static void DFS(int r, int c, int[][] arr, boolean[][] visited, int depth){
        if(depth == 4){
            answer = Math.max(answer, result);
            return;
        }
        for(int i=0; i<4; i++){
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if(checkRange(nr, nc, arr) && !visited[nr][nc]) {
                visited[nr][nc] = true;
                result += arr[nr][nc];
                DFS(nr, nc, arr, visited, depth+1);
                visited[nr][nc] = false;
                result -= arr[nr][nc];
            }
        }
    }

    public static boolean checkRange(int r, int c, int[][] arr){
        return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
    }
}
