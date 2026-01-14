import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            for(int i=0; i<10; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            double result = 0;
            for(int i=1; i<=8; i++){
                result += arr[i];
            }
            result /= 8;
            int answer = (int)Math.round(result);
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
}