import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
        for(int num = 1; num<=N; num++){
            bw.write(check(num));
            bw.write(" ");
        }
        bw.flush();
	}
    public static String check(int num){
        if(num < 10){
            if(num == 3 || num == 6 || num == 9){
                return "-";
            } else {
                return num + "";
            }
        } else {
            int count = 0;
            int temp = num;
            while(temp > 0){
                int digit = temp % 10;
                if(digit == 3 || digit == 6 || digit == 9){
                    count++;
                }
                temp /= 10;
            }
            if(count == 0){
                return num + "";
            } else {
                String result = "";
            	for(int i=0; i<count; i++){
                    result += "-";
                }
                return result;
            }
        }
    }
}