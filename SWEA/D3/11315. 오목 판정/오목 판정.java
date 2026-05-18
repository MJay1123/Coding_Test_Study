import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int[][] board;
    static int[][] move = {{1,0},{1,1},{0,1},{-1,1}};
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)	{
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            for(int r=0; r<N; r++){
                String str = br.readLine();
                for(int c=0; c<N; c++){
                    if(str.charAt(c) == 'o'){
                        board[r][c] = 1;
                    }
                }
            }
			boolean answer = check();
            sb.append("#").append(test_case).append(" ");
            if(answer){
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
		}
        bw.write(sb.toString());
        bw.flush();
	}
    public static boolean checkRange(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    public static boolean check(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(board[r][c] == 1){
                    for(int i=0; i<4; i++){
                        int count = 1;
                    	for(int d=1; d<=4; d++){
                        	int nr = r + move[i][0] * d;
                            int nc = c + move[i][1] * d;
                            if(checkRange(nr, nc) && board[nr][nc] == 1){
                                count++;
                            } else {
                                count = 0;
                            }
                        }
                        if(count == 5){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}