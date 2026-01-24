import java.util.*;
import java.io.*;

public class Main {
    static int C;
    static int R;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        if(K > R*C){
            bw.write(0 + "\n");
        } else {
            int[][] arr = new int[R][C];
            int r = 0;
            int c = 0;
            int num = 1;
            int depth = 0;
            int moveIndex = 0;
//            while (true) {
//                if (num + ((C - depth * 2) * 2 + (R - depth * 2) * 2 - 4) > K) {
//                    break;
//                }
//                num += ((C - depth * 2) * 2 + (R - depth * 2) * 2 - 4);
//                r++;
//                c++;
//                depth++;
//            }
            int d = r;
            int answerR = 0;
            int answerC = 0;
            while (true) {
                if (num == K) {
                    arr[r][c] = num;
                    answerR = r + 1;
                    answerC = c + 1;
                    break;
                }
                arr[r][c] = num++;
                int nr = r + move[moveIndex][0];
                int nc = c + move[moveIndex][1];
                if (!checkRange(nr, nc) || arr[nr][nc] > 0 || nr < d || nc < d || nr >= R-d || nc >= C-d ) {
                    moveIndex = (moveIndex + 1) % 4;
                    r += move[moveIndex][0];
                    c += move[moveIndex][1];
                } else {
                    r = nr;
                    c = nc;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(answerC).append(" ").append(answerR);
            bw.write(sb.toString());
        }
        bw.flush();
    }
    public static boolean checkRange(int r, int c){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}