import java.util.*;
class Solution {
    static int answer = 0;
    static int N;
    static boolean[][] board;
    static boolean[] columns;
    static boolean[][] diagonals;
    public int solution(int n) {
        N = n;
        board = new boolean[N][N];
        columns = new boolean[N];
        diagonals = new boolean[2][2*N];
        check(0);
        return answer;
    }
    public void check(int r){
        if(r == N){
            answer++;
            return;
        }
        for(int c=0; c<N; c++){
            if(!columns[c] && !diagonals[0][r+c] && !diagonals[1][r-c+N]){
                columns[c] = true;
                diagonals[0][r+c] = true;
                diagonals[1][r-c+N] = true;
                check(r+1);
                columns[c] = false;
                diagonals[0][r+c] = false;
                diagonals[1][r-c+N] = false;
            }
        }
    }
}