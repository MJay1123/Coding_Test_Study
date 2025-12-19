

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 5
public class Main {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];                    // 누적 합으로 표를 만들기(연산을 줄이기 위해서)
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int j=1; j<=N; j++) {
            sum += Integer.parseInt(st.nextToken());
            map[1][j] = sum;
        }
        for(int i=2; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            sum = 0;
            for(int j=1; j<=N; j++){
                sum += Integer.parseInt(st.nextToken());
                map[i][j] = map[i-1][j] + sum;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1];
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
