import java.util.*;
import java.io.*;

public class Main {
	static int m, n;
	static int[] starCriteria;
	static int[] photoCriteria;
	static List<Star> photo;
	static class Star {
		int x;
		int y;

		public Star(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Difference {
		int dx;
		int dy;

		public Difference(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}

		@Override
		public boolean equals(Object o) {
			Difference d = (Difference)o;
			return this.dx == d.dx && this.dy == d.dy;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.dx, this.dy);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		m = Integer.parseInt(br.readLine());
		HashSet<Difference> differenceSet = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		starCriteria = new int[2];
		starCriteria[0] = Integer.parseInt(st.nextToken());
		starCriteria[1] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());			
			differenceSet.add(new Difference(x - starCriteria[0], y - starCriteria[1]));
		}
		photoCriteria = new int[2];
		photo = new ArrayList<>();
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			photo.add(new Star(x, y));
		}
		for(int i=0; i<n; i++) {
			HashSet<Difference> hs = new HashSet<>();
			Star s = photo.get(i);
			photoCriteria[0] = s.x;
			photoCriteria[1] = s.y;
			for(int j=0; j<n; j++) {
				if(j == i) {
					continue;
				}
				Star ns = photo.get(j);
				hs.add(new Difference(ns.x - photoCriteria[0], ns.y - photoCriteria[1]));
			}
			boolean flag = true;
			for(Difference d : differenceSet) {
				if(!hs.contains(d)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		int dx = photoCriteria[0] - starCriteria[0];
		int dy = photoCriteria[1] - starCriteria[1];
		bw.write(dx + " " + dy);
		bw.flush();
	}

}
