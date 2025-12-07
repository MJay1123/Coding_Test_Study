package Gold.G4.BOJ9663;

import java.io.*;

public class Main2 {
    static int N;
    static int answer = 0;
    static int[][] move = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] board = new int[N];
        placeQueen(board, 0);
        bw.write(answer + "\n");
        bw.flush();
    }
    public static void placeQueen(int[] board, int c){
        if(c == N){
            answer++;
            return;
        }
        for (int r = 0; r < N; r++) {
            if (possible(board, r, c)) {
                board[c] = r;
                placeQueen(board, c + 1);
            }
        }
    }
    public static boolean possible(int[] board, int r, int c){
        if(c == 0){
            return true;
        }
        for(int i=0; i<c; i++){
            if(r == board[i] || Math.abs(c-i) == Math.abs(r - board[i])){
                return false;
            }
        }
        return true;
    }
}
