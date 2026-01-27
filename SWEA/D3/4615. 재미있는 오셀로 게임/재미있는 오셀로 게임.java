import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] board = new int[N+1][N+1];		// 1 : black, 2 : white
            board[N/2][N/2] = 2;
            board[N/2 + 1][N/2] = 1;
            board[N/2][N/2 + 1] = 1;
            board[N/2 + 1][N/2 + 1] = 2;
            int[][] move = {{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1, -1}};
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                board[r][c] = color;
                for(int m=0; m<8; m++){
                    for(int d=1; d<=N; d++){
                        int nr = r + move[m][0] * d;
                        int nc = c + move[m][1] * d;
                        if(checkRange(nr, nc, N)){
                            if(board[nr][nc] == color) {
                                changeColor(r, c, nr, nc, color, board);
                                break;
                            } else if(board[nr][nc] == 3-color){
                                continue;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            int[] count = new int[2];
            for(int r=1; r<=N; r++){
                for(int c=1; c<=N; c++){
                    if(board[r][c] == 1){
                        count[0]++;
                    } else if(board[r][c] == 2){
                        count[1]++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(count[0]).append(" ").append(count[1]).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }
    public static void changeColor(int r, int c, int nr, int nc, int color,  int[][] board){
        if(r == nr){
            for(int i=Math.min(c, nc); i<=Math.max(c, nc); i++){
                board[r][i] = color;
            }
            return;
        }
        if(c == nc){
            for(int i=Math.min(r, nr); i<=Math.max(r, nr); i++){
                board[i][c] = color;
            }
            return;
        }
        if(r-c == nr-nc){
            for(int i=Math.min(r, nr); i<=Math.max(r, nr); i++){
                for(int j=Math.min(c, nc); j<=Math.max(c, nc); j++){
                    if(i-j == r-c) {
                        board[i][j] = color;
                    }
                }
            }
            return;
        }
        if(r+c == nr+nc){
            for(int i=Math.min(r, nr); i<=Math.max(r, nr); i++){
                for(int j=Math.min(c, nc); j<=Math.max(c, nc); j++){
                    if(i+j == r+c) {
                        board[i][j] = color;
                    }
                }
            }
            return;
        }
    }
    public static boolean checkRange(int r, int c, int N){
        return r >= 1 && r <= N && c >= 1 && c <= N;
    }
}