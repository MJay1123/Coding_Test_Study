import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            String memory = br.readLine();
            int answer = 0;
            int start = 0;
            for(int i=0; i<memory.length(); i++){
                if(memory.charAt(i) == '1'){
                    answer++;
                    start = i;
                    break;
                }
            }
            for(int i=start+1; i<memory.length(); i++){
                if(memory.charAt(i) != memory.charAt(i-1)){
                    answer++;
                }
            }
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}