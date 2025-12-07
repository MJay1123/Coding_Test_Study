package Gold.G4.BOJ9663;

import java.io.*;

public class Main {
    static int N;
    static int answer = 0;
    static int[][] move = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        boolean[][] chessBoard = new boolean[N][N];
        int[][] arr = new int[N][N];
        placeQueen(chessBoard, arr, 0, 0, 0, N);
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void placeQueen(boolean[][] chessBoard, int[][] arr, int r, int c, int depth, int count){
        if(depth == count){
            answer++;
            return;
        }
        if(r >= chessBoard.length){
            return;
        }
        if(c >= chessBoard[0].length){
            return;
        }
        if(arr[r][c] == 0) {
            chessBoard[r][c] = true;
            checkBoard(r, c, arr, 1);
            placeQueen(chessBoard, arr, 0, c+1, depth + 1, count);
            chessBoard[r][c] = false;
            checkBoard(r, c, arr, -1);
        }
        placeQueen(chessBoard, arr, r+1, c, depth, count);
    }
    public static void checkBoard(int r, int c, int[][] arr, int num){
        arr[r][c] += num;
        for(int d=1; d<N; d++){
            for(int i=0; i<8; i++){
                int nr = r + move[i][0] * d;
                int nc = c + move[i][1] * d;
                if (checkRange(nr, nc)) {
                    arr[nr][nc] += num;
                }
            }
        }
    }

    public static boolean checkRange(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
