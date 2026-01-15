import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            boolean[] whiteR = new boolean[H];
            boolean[] whiteC = new boolean[W];
            for(int r=0; r<H; r++){
                String line = br.readLine();
                for(int c=0; c<W; c++){
                    if(line.charAt(c) == '.'){
                        whiteR[r] = true;
                        whiteC[c] = true;
                    }
                }
            }
            int rCount = 0;
            int cCount = 0;
            for(int r=0; r<H; r++){
                if(!whiteR[r]){
                    rCount++;
                }
            }
            for(int c=0; c<W; c++){
                if(!whiteC[c]){
                    cCount++;
                }
            }
            int answer = 0;
            if(rCount == H || cCount == W){
                answer = Math.min(H, W);
            } else {
                answer = rCount + cCount;
            }
            bw.write(answer + "\n");
		}
        bw.flush();
	}
}