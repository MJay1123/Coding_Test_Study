import java.util.*;
import java.io.*;
class Solution {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++){
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] candies = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                candies[i] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            int minimum = 1000000;
            int sum = 0;
            for(int i=0; i<N; i++){
                minimum = Math.min(minimum, candies[i]);
                sum += candies[i];
                result = result ^ candies[i];
            }
            if(result != 0){
            	sb.append("NO");
            } else {
                sb.append(sum - minimum);
            }
            sb.append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
}