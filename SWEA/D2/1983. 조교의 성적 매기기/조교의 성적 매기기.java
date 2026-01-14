import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        double[] rate = {0.35, 0.45, 0.2};
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            double[] scores = new double[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++){
                	scores[i] += rate[j] * Integer.parseInt(st.nextToken());
                }
            }
            int rank = 0;
            for(int i=0; i<N; i++){
                if(i == K-1){
                    continue;
                }
                if(scores[i] > scores[K-1]){
                    rank++;
                }
            }
            String answer = grades[rank / (N/10)];
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
}