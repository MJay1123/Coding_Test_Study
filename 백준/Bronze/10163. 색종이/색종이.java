import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] papers = new int[N+1][4];
        for(int n=1; n<=N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                papers[n][i] = Integer.parseInt(st.nextToken());    // {r, c, width, height}
            }
        }
        int[][] map = new int[1001][1001];
        int[] counts = new int[N+1];
        for(int n=1; n<=N; n++){
            putPaper(n, papers, map, counts);
        }
        StringBuilder sb = new StringBuilder();
        for(int n=1; n<=N; n++){
            sb.append(counts[n]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void putPaper(int num, int[][] papers, int[][] map, int[] counts){
        int[] paper = papers[num];
        int startC = paper[0];
        int startR = paper[1];
        int width = paper[2];
        int height = paper[3];
        for(int r=startR; r<startR+height; r++){
            for(int c=startC; c<startC+width; c++){
                if(map[r][c] != 0){
                    counts[map[r][c]]--;
                }
                map[r][c] = num;
                counts[num]++;
            }
        }
    }
}