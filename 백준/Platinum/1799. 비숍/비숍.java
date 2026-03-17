import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] chessBoard;
	static List<Integer>[] possiblePoints; // r + c
	static int[] putCounts; // r - c
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		chessBoard = new int[N][N];
		possiblePoints = new List[2 * N - 1];
		for (int i = 0; i < 2 * N - 1; i++) {
			possiblePoints[i] = new ArrayList<>();
		}
		putCounts = new int[2 * N - 1];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				chessBoard[r][c] = Integer.parseInt(st.nextToken());
				if (chessBoard[r][c] == 1) {
					possiblePoints[r + c].add(r - c + N - 1);
				}
			}
		}
		answer = 0;
		put(0, 0);
		bw.write(answer + "\n");
		bw.flush();
	}

	public static void put(int index, int count) {
		if (index == N + N - 1) {
			answer = Math.max(answer, count);
			return;
		}
		if(count + (2 * N - 1) - index < answer) {
			return;
		}
		for (int n : possiblePoints[index]) {
			if (putCounts[n] == 0) {
				putCounts[n]++;
				put(index + 1, count + 1);
				putCounts[n]--;
			}
		}
		put(index + 1, count);
	}
}
