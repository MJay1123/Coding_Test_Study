import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = getSecond(0, 0, N);
		bw.write(answer + "\n");
		bw.flush();
	}
	public static int getSecond(int r, int c, int l) {
		int[] arr = new int[4];
		if(l == 2) {
			arr[0] = map[r][c];
			arr[1] = map[r+1][c];
			arr[2] = map[r][c+1];
			arr[3] = map[r+1][c+1];
		} else {
			arr[0] = getSecond(r, c, l/2);
			arr[1] = getSecond(r + l/2, c, l/2);
			arr[2] = getSecond(r, c + l/2, l/2);
			arr[3] = getSecond(r + l/2, c + l/2, l/2);
		}
		Arrays.sort(arr);
		return arr[2];
	}
}
