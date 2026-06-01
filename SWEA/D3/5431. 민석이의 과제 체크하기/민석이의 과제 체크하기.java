import java.util.*;
import java.io.*;
class Solution {
    static int N, K;
    static boolean[] students;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            students = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                int num = Integer.parseInt(st.nextToken());
                students[num] = true;
            }
            for(int i=1; i<=N; i++){
                if(!students[i]){
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
}