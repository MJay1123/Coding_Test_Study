import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            for(int i=1; i<=N; i++){
                if(i % 2 == 1){
                    answer += i;
                } else {
                    answer -= i;
                }
            }
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
}