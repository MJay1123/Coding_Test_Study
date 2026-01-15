import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
			String answer = compare(a, b);
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
    public static String compare(int a, int b){
        if(a < b){
            return "<";
        } else if(a > b){
            return ">";
        } else {
            return "=";
        }
    }
}