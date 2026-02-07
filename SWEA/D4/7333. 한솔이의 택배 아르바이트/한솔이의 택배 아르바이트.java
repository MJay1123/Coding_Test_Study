import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			int left = 0;
			int right = N-1;
			int count = 0;
			while(left <= right) {
				count++;
				if(arr[right] >= 50) {
					right--;
				} else {
					int needCount = 50 / (arr[right]+1) + 1;
					left += (needCount - 1);
					right--;
					if(left > right + 1) {
						count--;
					}
				}
			}
            int answer = count;
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}