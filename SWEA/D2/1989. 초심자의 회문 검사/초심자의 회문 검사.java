import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int answer = 1;
            String str = br.readLine();
            for(int i=0; i<str.length()/2; i++){
                if(str.charAt(i) != str.charAt(str.length()-1-i)){
                    answer = 0;
                    break;
                }
            }
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
}