import java.util.*;
import java.io.*;

class Solution {
	static int max, min;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] calculation = new int[4];		// {+, -, *, /}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				calculation[i] = Integer.parseInt(st.nextToken());
			}
			int[] numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			max = -1000000000;
			min = 1000000000;
			int[] usedCalc = new int[4];
			P(1, numbers[0], numbers, calculation, usedCalc);
            int answer = max - min;
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static void P(int index, int result, int[] numbers, int[] calculation, int[] usedCalc) {
		if(index == numbers.length) {
			max = Math.max(max, result);
			min = Math.min(min, result);
		}
		if(usedCalc[0] < calculation[0]) {
			usedCalc[0]++;
			P(index+1, result + numbers[index], numbers, calculation, usedCalc);
			usedCalc[0]--;
		}
		if(usedCalc[1] < calculation[1]) {
			usedCalc[1]++;
			P(index+1, result - numbers[index], numbers, calculation, usedCalc);
			usedCalc[1]--;
		}
		if(usedCalc[2] < calculation[2]) {
			usedCalc[2]++;
			P(index+1, result * numbers[index], numbers, calculation, usedCalc);
			usedCalc[2]--;
		}
		if(usedCalc[3] < calculation[3]) {
			usedCalc[3]++;
			P(index+1, result / numbers[index], numbers, calculation, usedCalc);
			usedCalc[3]--;
		}
	}
}