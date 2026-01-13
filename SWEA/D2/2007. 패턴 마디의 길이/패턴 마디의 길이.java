import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int answer = 0;
            for(int l=1; l<=10; l++){
                if(check(str, l)){
                    answer = l;
                    break;
                }
            }
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
    public static boolean check(String str, int l){
        for(int i=0; i<l; i++){
            if(str.charAt(i) != str.charAt(l+i)){
                return false;
            }
        }
        return true;
    }
}