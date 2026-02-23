import java.util.*;
import java.io.*;

public class Main {
	static int n, m, r;
	static int[] itemCounts;
	static int[][] roads;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		itemCounts = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			itemCounts[i] = Integer.parseInt(st.nextToken());
		}
		roads = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			Arrays.fill(roads[i], 100000);
			roads[i][i] = 0;
		}
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			roads[a][b] = l;
			roads[b][a] = l;
		}
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(roads[i][j] > roads[i][k] + roads[k][j]) {
						roads[i][j] = roads[i][k] + roads[k][j];
					}
				}
			}
		}
		int answer = 0;
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=1; j<=n; j++) {
				if(roads[i][j] <= m) {
					sum += itemCounts[j];
				}
			}
			answer = Math.max(answer,sum);
		}
		bw.write(answer + "\n");
		bw.flush();
	}
}
