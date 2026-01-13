import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            String number = br.readLine();
            if(check(number)){
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
		}
        bw.flush();
	}
    public static boolean check(String number){
        int[] index = new int[10];
        for(int i=0; i<10; i++){
            index[i] = -1;
        }
        for(int i=0; i<number.length(); i++){
            int num = number.charAt(i) - '0';
            if(index[num] == -2){
                return false;
            }
            if(index[num] == -1){
                index[num] = i;
            } else {
                if(i - index[num] == num + 1){
                    index[num] = -2;
                } else {
                    return false;
                }
            }
        }
        for(int i=0; i<10; i++){
            if(index[i] >= 0){
                return false;
            }
        }
        return true;
    }
}