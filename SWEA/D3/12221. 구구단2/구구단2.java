import java.util.*;
import java.io.*;
public class Solution {
    static int A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int answer = A * B;
            if(A >= 10 || B >= 10){
                answer = -1;
            }
            sb.append(String.format("#%d %d\n", testCase, answer));
        }
		bw.write(sb.toString());
        bw.flush();
    }
}