import java.util.*;
import java.io.*;
public class Solution {
    static int N;
    static double[] p;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
			N = Integer.parseInt(br.readLine());
            p = new double[N];
            x = new int[N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                p[i] = Double.parseDouble(st.nextToken());
                x[i] = Integer.parseInt(st.nextToken());
            }
            double answer = 0;
            for(int i=0; i<N; i++){
                answer += p[i] * x[i];
            }
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}