import java.util.*;
import java.io.*;
public class Solution {
	static int N, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	D = Integer.parseInt(st.nextToken());
        	int range = D * 2 + 1;
            int answer = N / range;
            if(N % range > 0) {
            	answer++;
            }
            sb.append(String.format("#%d %d\n", tc, answer));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}