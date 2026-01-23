import java.util.*;
import java.io.*;

class Solution {
    static boolean finish = false;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tallest = 0;
            for(int i=0; i<N; i++){
                trees[i] = Integer.parseInt(st.nextToken());
                tallest = Math.max(tallest, trees[i]);
            }
			int answer = 0;
            int oneCount = 0;
            int twoCount = 0;
            for(int i=0; i<N; i++){
                twoCount  += (tallest - trees[i]) / 2;
                oneCount += (tallest - trees[i]) % 2;
            }
            int temp = Math.min(oneCount, twoCount);
            answer += temp * 2;
            oneCount -= temp;
            twoCount -= temp;
            if(oneCount > 0){
                answer += (oneCount - 1) * 2 + 1;
            } else if(twoCount > 0){
                answer += twoCount / 3 * 4;
                if(twoCount % 3 > 0){
                    answer += twoCount % 3 + 1;
                }
            }
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}