import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] defaultArray = { { 1, 0 }, { 1, 1 } };;
	static StringBuilder[] sbs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int k = (int) (Math.log(N / 3) / Math.log(2));
		sbs = new StringBuilder[N];
		for (int i = 0; i < N; i++) {
			sbs[i] = new StringBuilder();
			for (int j = 0; j < N - 1 - i; j++) {
				sbs[i].append(' ');
			}
		}
		int[][] arr = getArray(N / 3);
		for (int r = 0; r < N / 3; r++) {
			for (int c = 0; c < N / 3; c++) {
				print(r, arr[r][c]);
			}
		}
		for (int i = 0; i < N; i++) {
			bw.write(sbs[i].substring(0, N*2) + "\n");
		}
		bw.flush();
	}

	static char[][] triangle = { { '*', ' ', ' ', ' ', ' ', ' ' }, { '*', ' ', '*', ' ', ' ', ' ' },
			{ '*', '*', '*', '*', '*', ' ' } };
	static char[][] empty = { { ' ', ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ' } };

	public static void print(int r, int type) {
		if (type == 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {
					sbs[r * 3 + i].append(triangle[i][j]);
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {
					sbs[r * 3 + i].append(empty[i][j]);
				}
			}
		}
	}

	public static int[][] getArray(int length) {
		if (length > 2) {
			int[][] arr = getArray(length / 2);
			int[][] result = new int[length][length];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (defaultArray[i][j] == 1) {
						int row = length / 2 * i;
						int column = length / 2 * j;
						for (int r = 0; r < length / 2; r++) {
							for (int c = 0; c < length / 2; c++) {
								result[row + r][column + c] = arr[r][c];
							}
						}
					}
				}
			}
			return result;
		} else {
			return defaultArray;
		}
	}
}
