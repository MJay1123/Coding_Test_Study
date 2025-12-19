import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 체스판 칠하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[][] board = new String[n][m];
        for(int i=0; i<n; i++){
            String k = br.readLine();
            String[] kk = k.split("");
            for(int j=0; j<m; j++){
                board[i][j] = kk[j];
            }
        }
        int min = m*n;
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                String[][] cutBoard = new String[8][8];
                for(int x=0; x<8; x++){
                    for(int y=0; y<8; y++){
                        cutBoard[x][y] = board[i+x][j+y];
                    }
                }
                int result = Math.min(check1(cutBoard), check2(cutBoard));
                min = Math.min(min, result);
            }
        }
        System.out.println(min);
    }

    public static int check1(String[][] board){
        int count = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if((i+j)%2 == 0){
                    if(board[i][j].equals("B")){
                        count++;
                    }
                } else if((i+j)%2 == 1){
                    if (board[i][j].equals("W")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int check2(String[][] board){
        int count = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if((i+j)%2 == 1){
                    if(board[i][j].equals("B")){
                        count++;
                    }
                } else if((i+j)%2 == 0){
                    if (board[i][j].equals("W")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
