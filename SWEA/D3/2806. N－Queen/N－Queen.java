import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = Integer.parseInt(br.readLine());
            boolean[][] chessBoard = new boolean[N][N];
            boolean[] usedRows = new boolean[N];
            boolean[] usedColumns = new boolean[N];
            boolean[] usedDiagonals1 = new boolean[2*N-1];		// 우상향 대각선 : r + c
            boolean[] usedDiagonals2 = new boolean[2*N-1];		// 우하향 대각선 : r - c
            int answer = placeQueen(0, chessBoard, usedColumns, usedDiagonals1, usedDiagonals2);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
     public static int placeQueen(int r, boolean[][] chessBoard, boolean[] usedColumns, boolean[] usedDiagonals1, boolean[] usedDiagonals2){
            int n = chessBoard.length;
            int result = 0;
            if(r == n){
                return 1;
            }
            for(int c=0; c<n; c++){
                if(!usedColumns[c] && !usedDiagonals1[r+c] && !usedDiagonals2[r-c+n-1]){
                    chessBoard[r][c] = true;
                    usedColumns[c] = true;
                    usedDiagonals1[r+c] = true;
                    usedDiagonals2[r-c+n-1] = true;
                    result += placeQueen(r+1, chessBoard, usedColumns, usedDiagonals1, usedDiagonals2);
                    chessBoard[r][c] = false;
                    usedColumns[c] = false;
                    usedDiagonals1[r+c] = false;
                    usedDiagonals2[r-c+n-1] = false;
                }
            }
            return result;
        }
}