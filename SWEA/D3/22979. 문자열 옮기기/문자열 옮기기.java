import java.util.*;
import java.io.*;
public class Solution {
    static String S;
    static int K;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            S = br.readLine();
            K = Integer.parseInt(br.readLine());
            int index = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                int calc = Integer.parseInt(st.nextToken());
                if(calc > 0){
                    index = (index + calc) % S.length();
                } else if(calc < 0){
                    index = (index + (calc % S.length() + S.length())) % S.length();
                }
            }
            sb.append(S.substring(index)).append(S.substring(0, index)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}