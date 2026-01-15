import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= TC; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long S = Long.parseLong(st.nextToken());
            long P = Long.parseLong(st.nextToken());
            boolean answer = binarySearch(S, P);
            if(answer){
                bw.write("Yes\n");
            } else {
                bw.write("No\n");
            }
		}
        bw.flush();
	}
    public static boolean binarySearch(long S, long P){
        long leftStart = S / 2;
        long rightStart = S / 2;
        if(S % 2 == 1){
            rightStart++;
        }
        long left = leftStart;
        long right = rightStart;
        long min = 0;
        long max = left - 1;
        while(min <= max){
            long distance = (min + max) / 2;
            left = leftStart - distance;
            right = rightStart + distance;
            if (left != 0 && right > Long.MAX_VALUE / left) {
                // 곱이 너무 크면 P보다 확실히 큰 것이므로 차이를 더 벌려야 함
                min = distance + 1;
                continue;
            }
            if(left * right == P){
                return true;
            }
            if(left * right > P){
                min = distance + 1;
            } else {
                max = distance - 1;
            }
        }
        return false;
    }
}