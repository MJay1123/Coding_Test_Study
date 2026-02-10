import java.util.*;
import java.io.*;

public class Main {
	static int[][] cubeRange = { 
			{ 0, 0, 0, 1, 1, 1, 2, 2, 2 },
			{ 0, 0, 0, 1, 1, 1, 2, 2, 2 },
			{ 0, 0, 0, 1, 1, 1, 2, 2, 2 },
			{ 3, 3, 3, 4, 4, 4, 5, 5, 5 }, 
			{ 3, 3, 3, 4, 4, 4, 5, 5, 5 },
			{ 3, 3, 3, 4, 4, 4, 5, 5, 5 }, 
			{ 6, 6, 6, 7, 7, 7, 8, 8, 8 }, 
			{ 6, 6, 6, 7, 7, 7, 8, 8, 8 },
			{ 6, 6, 6, 7, 7, 7, 8, 8, 8 } 
			};
	static int[][] sudoku = new int[9][9];
	static boolean[][] rowNumbers = new boolean[9][10];
	static boolean[][] columnNumbers = new boolean[9][10];
	static boolean[][] cubeNumbers = new boolean[9][10];
	static List<int[]> emptyList = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static boolean printed = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int r = 0; r < 9; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				int num = Integer.parseInt(st.nextToken());
				sudoku[r][c] = num;
				if (num == 0) {
					emptyList.add(new int[] { r, c });
				} else {
					int cubeIndex = cubeRange[r][c];
					cubeNumbers[cubeIndex][num] = true;
					rowNumbers[r][num] = true;
					columnNumbers[c][num] = true;
				}
			}
		}
		fill(0);
		bw.write(sb.toString());
		bw.flush();
	}

	public static List<Integer> getCommon(boolean[] arr1, boolean[] arr2, boolean[] arr3) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			if (!arr1[i] && !arr2[i] && !arr3[i]) {
				list.add(i);
			}
		}
		return list;
	}

	public static void fill(int index) {
		if (printed) {
			return;
		}
		if (index == emptyList.size()) {
			print();
			return;
		}
		int r = emptyList.get(index)[0];
		int c = emptyList.get(index)[1];
		int cubeIndex = cubeRange[r][c];
		List<Integer> possibleNumbers = getCommon(rowNumbers[r], columnNumbers[c], cubeNumbers[cubeIndex]);
		for (int num : possibleNumbers) {
			if (printed) {
				return;
			}
			sudoku[r][c] = num;
			cubeNumbers[cubeIndex][num] = true;
			rowNumbers[r][num] = true;
			columnNumbers[c][num] = true;
			fill(index + 1);
			sudoku[r][c] = 0;
			cubeNumbers[cubeIndex][num] = false;
			rowNumbers[r][num] = false;
			columnNumbers[c][num] = false;
		}
	}

	public static void print() {
		printed = true;
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(sudoku[r][c]).append(" ");
			}
			sb.append("\n");
		}
	}
}