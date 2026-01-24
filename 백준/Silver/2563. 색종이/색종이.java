import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];
        int answer = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lDist = Integer.parseInt(st.nextToken());
            int dDist = Integer.parseInt(st.nextToken());
            for(int r=lDist; r<lDist+10; r++){
                for(int c=dDist; c<dDist+10; c++){
                    if(paper[r][c] == 0){
                        answer++;
                    }
                    paper[r][c]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}

