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
			int num = N;
			int numbers = addNumbers(N);
			int count = 1;
			while(true) {
				count++;
				num += N;
				numbers = numbers | addNumbers(num);
				if(numbers == (1 << 10) - 1) {
					break;
				}
			}
            sb.append(num).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static int addNumbers(int num) {
		int numbers = 0;
		while(num > 0) {
			int digit = num % 10;
			numbers = numbers | (1 << digit);
			num /= 10;
		}
		return numbers;
	}
}