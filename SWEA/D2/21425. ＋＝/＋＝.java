import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int count = 0;
            while(A <= N && B <= N){
                if(A <= B){
                    A += B;
                } else {
                    B += A;
                }
                count++;
            }
            bw.write(count + "\n");
		}
        bw.flush();
	}
}