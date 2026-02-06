import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String color1 = st.nextToken();
			String color2 = st.nextToken();
			int num1 = colorToNum(color1);
			int num2 = colorToNum(color2);
			if (num1 == num2) {
				sb.append("E");
			} else if (num2 == (num1 + 1) % 6 || num2 == (num1 + 5) % 6) {
				sb.append("A");
			} else if(num2 == (num1 + 3) % 6) {
				sb.append("C");
			} else {
				sb.append("X");
			}
			sb.append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static int colorToNum(String color) {
		switch (color) {
		case "purple":
			return 0;
		case "blue":
			return 1;
		case "green":
			return 2;
		case "yellow":
			return 3;
		case "orange":
			return 4;
		case "red":
			return 5;
		}
		return -1;
	}
}