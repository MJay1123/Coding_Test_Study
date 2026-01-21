import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine().trim();
            int len = str.length();
            int answer = 0;
            for(int i=0; i<len; i++){
                int d = 1;
                int length = 1;
                while(true){
                    if(i-d >= 0 && i+d < len){
                        if(str.charAt(i-d) == str.charAt(i+d)){
                            length += 2;
                            d++;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                answer = Math.max(answer, length);
            }
            for(int i=0; i<len-1; i++){
                if(str.charAt(i) == str.charAt(i+1)){
                    int left = i;
                    int right = i+1;
                    int d = 1;
                    int length = 2;
                    while(true){
                        if(left-d >= 0 && right+d < len){
                            if(str.charAt(left-d) == str.charAt(right+d)){
                                d++;
                                length += 2;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    answer = Math.max(answer, length);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}