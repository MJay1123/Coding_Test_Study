import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());
            int temp = 2 * Z - X - Y;
            int answer = 0;
            if(temp >= 0){
                answer = X*B + Y*W + temp * Math.min(B, W);
            } else {
                answer = X*B + Y*W;
            }
            bw.write(answer + "\n");
		}
        bw.flush();
	}
}