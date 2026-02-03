import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			int N = Integer.parseInt(br.readLine());
			int answer = 1;
			for(int i=1; i<=N; i++) {
				String str = br.readLine();
				String[] arr = str.split(" ");
				if(!isCorrect(arr)) {
					answer = 0;
				}
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static boolean isCorrect(String[] arr) {
		if(arr.length == 2) {
			if(isCalculation(arr[1])) {
				return false;
			}
		} else if(arr.length == 4){
			if(isNumber(arr[1])) {
				return false;
			}
			if(isCalculation(arr[2]) || isCalculation(arr[3])) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	public static boolean isCalculation(String str) {
		if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
			return true;
		}
		return false;
	}
	public static boolean isNumber(String str) {
		if(str.charAt(0) < '0' || str.charAt(0) > '9') {
			return false;
		}
		return true;
	}
}