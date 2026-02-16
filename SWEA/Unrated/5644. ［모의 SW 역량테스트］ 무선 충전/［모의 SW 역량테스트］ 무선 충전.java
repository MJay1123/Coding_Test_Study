import java.util.*;
import java.io.*;

public class Solution {
	static int M, A;
	static int[][] directionArray;
	static int[][] directions = {{0,0},{0,-1},{1,0},{0,1},{-1,0}};
	static BC[] arrayBC;
	static User userA, userB;
	static class User {
		int x, y;
		public User(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public void move(int direction) {
			x += directions[direction][0];
			y += directions[direction][1];
		}
	}
	static class BC implements Comparable<BC> {
		int x, y, C, P;
		public BC(int x, int y, int C, int P) {
			this.x = x;
			this.y = y;
			this.C = C;
			this.P = P;
		}
		@Override
		public int compareTo(BC o) {
			return o.P - this.P;
		}
//		@Override
//		public boolean equals(Object o) {
//			BC bc = (BC)o;
//			return this.x == bc.x && this.y == bc.y && this.C == bc.C && this.P == bc.P;
//		}
//		@Override
//		public int hashCode() {
//			return Objects.hash(x, y, C, P);
//		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());	// 총 이동 시간
			A = Integer.parseInt(st.nextToken());	// BC의 개수
			directionArray = new int[2][M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				directionArray[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				directionArray[1][i] = Integer.parseInt(st.nextToken());
			}
			arrayBC = new BC[A];
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				arrayBC[i] = new BC(x, y, C, P);
			}
			userA = new User(1,1);
			userB = new User(10,10);
			PriorityQueue<BC> pqA = new PriorityQueue<>();
			PriorityQueue<BC> pqB = new PriorityQueue<>();
			int answer = 0;
			answer += checkBC(pqA, pqB);
			for(int t=0; t<M; t++) {
				userA.move(directionArray[0][t]);
				userB.move(directionArray[1][t]);
				answer += checkBC(pqA, pqB);
			}
			bw.write("#" + testCase + " " + answer + "\n");
		}
		bw.flush();
	}
	public static int checkBC(PriorityQueue<BC> pqA, PriorityQueue<BC> pqB){
		pqA.clear();
		pqB.clear();
		for(int i=0; i<A; i++) {
			BC bc = arrayBC[i];
			if(getDistance(userA.x, userA.y, bc.x, bc.y) <= bc.C) {
				pqA.offer(bc);
			}
			if(getDistance(userB.x, userB.y, bc.x, bc.y) <= bc.C) {
				pqB.offer(bc);
			}
		}
		int result = 0;
		if(pqA.isEmpty()) {
			if(pqB.isEmpty()) {
				return 0;
			} else {
				return pqB.peek().P;
			}
		} else {
			if(pqB.isEmpty()) {
				return pqA.peek().P;
			} else {
				if(pqB.peek().equals(pqA.peek())) {
					result += pqA.poll().P;
					pqB.poll();
					result += Math.max(pqA.isEmpty() ? 0 : pqA.peek().P, pqB.isEmpty() ? 0 : pqB.peek().P);
					return result;
				} else {
					return pqA.peek().P + pqB.peek().P;
				}
			}
		}
	}
	
	public static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
}
