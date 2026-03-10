import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] map;
	static class Person {
		int r;
		int c;
		int usedStair;
		int stairArrivedTime;
		int time;
		public Person(int r, int c, int num) {
			this.r = r;
			this.c = c;
		}
	}
	static class Stair {
		int r;
		int c;
		int time;
		List<Person> list;
		public Stair(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.list = new ArrayList<>();
		}
	}
	static List<Person> people = new ArrayList<>();
	static Stair[] stairs = new Stair[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			people.clear();
			int peopleIndex = 0;
			int stairIndex = 0;
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 1) {
						people.add(new Person(r, c, peopleIndex++));
					}
					if(map[r][c] >= 2) {
						stairs[stairIndex++] = new Stair(r, c, map[r][c]);
					}
				}
			}
			int answer = 1000000;
			for(int i=0; i<(1 << people.size()); i++) {
				chooseStairs(i);
				answer = Math.min(answer,  downStairs());
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int downStairs() {
		stairs[0].list.clear();
		stairs[1].list.clear();
		int time = 0;
		int count = 0;
		while(true) {
			if(count == people.size()) {
				return time;
			}
			time++;
			int temp = 0;
			for(Person p : stairs[0].list) {
				if(p.time == stairs[0].time) {
					continue;
				}
				p.time++;
				if(p.time == stairs[0].time) {
					count++;
				}
				temp++;
				if(temp == 3) {
					break;
				}
			}
			temp = 0;
			for(Person p : stairs[1].list) {
				if(p.time == stairs[1].time) {
					continue;
				}
				p.time++;
				if(p.time == stairs[1].time) {
					count++;
				}
				temp++;
				if(temp == 3) {
					break;
				}
			}
			for(int i=0; i<people.size(); i++) {
				Person p = people.get(i);
				if(p.stairArrivedTime + 1 == time) {
					p.time = 0;
					if(p.usedStair == 0) {
						stairs[0].list.add(p);
					} else {
						stairs[1].list.add(p);
					}
				}
			}
		}
	}
	public static void chooseStairs(int bit) {
		for(int i=0; i<people.size(); i++) {
			Person p = people.get(i);
			if((bit & (1 << i)) == 0) {
				p.usedStair = 0;
				p.stairArrivedTime = getDistance(p.r, p.c, stairs[0].r, stairs[0].c);
			} else {
				p.usedStair = 1;
				p.stairArrivedTime = getDistance(p.r, p.c, stairs[1].r, stairs[1].c);
			}
		}
	}
	public static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
}
