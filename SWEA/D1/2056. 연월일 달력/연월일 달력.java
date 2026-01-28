import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
        int[] dayOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            boolean available = false;
            String str = br.readLine();
            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            String day = str.substring(6);
            if(Integer.parseInt(month) > 0 && Integer.parseInt(month) <= 12){
                if(Integer.parseInt(day) > 0 && Integer.parseInt(day) <= dayOfMonth[Integer.parseInt(month)]){
                    available = true;
                }
            }
            if(available){
                sb.append(year).append("/").append(month).append("/").append(day);
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
		bw.flush();
	}
}