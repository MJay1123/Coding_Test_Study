import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
        int[] counts = {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};
		for(int test_case = 1; test_case <= T; test_case++) {
            int X = Integer.parseInt(br.readLine());
            String answer = "";
            if(X == 1){
                answer = "0";
            } else {
                while(X > 0){
                    if(X >= 2){
                        X -= 2;
                        answer = answer + "8";
                    } else {
                        X--;
                        answer = "4" + answer;
                	}
                }
            }
            bw.write(answer + "\n");
		}
        bw.flush();
	}
}