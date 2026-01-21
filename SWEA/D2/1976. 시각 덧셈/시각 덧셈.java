import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hour1 = Integer.parseInt(st.nextToken());
            int minute1 = Integer.parseInt(st.nextToken());
            int time1 = hour1 * 60 + minute1;
            int hour2 = Integer.parseInt(st.nextToken());
            int minute2 = Integer.parseInt(st.nextToken());
            int time2 = hour2 * 60 + minute2;
            int sum = time1 + time2;
            int sumHour = sum / 60;
            if(sumHour > 12){
                sumHour -= 12;
            }
            int sumMinute = sum % 60;
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(sumHour).append(" ").append(sumMinute).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
}