import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, K, A, B;
	static int[] a;
	static int[] b;
	static int[] t;
	static class Customer {
		int number;
		int arrivedTime;
		Integer reception;
		Integer repair;
		public Customer(int number, int arrivedTime) {
			this.number = number;
			this.arrivedTime = arrivedTime;
		}
		@Override
		public String toString() {
			return "Customer [number=" + number + ", arrivedTime=" + arrivedTime + ", reception=" + reception
					+ ", repair=" + repair + "]";
		}
	}
	static class Desk {
		int number;
		int time;
		Customer customer;
		int remainedTime;
		public Desk(int number, int time) {
			this.number = number;
			this.time = time;
		}
	}
	static int time;
	static Queue<Customer> receptionWaiting, repairWaiting;
	static Desk[] receptionDesks, repairDesks;
	static List<Customer> finishedList;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			a = new int[N+1];
			b = new int[M+1];
			t = new int[K+1];
			receptionWaiting = new LinkedList<>();
			repairWaiting = new LinkedList<>();
			receptionDesks = new Desk[N+1];
			repairDesks = new Desk[M+1];
			finishedList = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				receptionDesks[i] = new Desk(i, a[i]);
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
				repairDesks[i] = new Desk(i, b[i]);
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++) {
				t[i] = Integer.parseInt(st.nextToken());
				receptionWaiting.offer(new Customer(i, t[i]));
			}
			time = 0;
			answer = 0;
			while(true) {
				timePass();
				if(finishedList.size() == K) {
					break;
				}
			}
			for(Customer c : finishedList) {
				if(c.reception == A && c.repair == B) {
					answer += c.number;
				}
			}
			if(answer == 0) {
				answer = -1;
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void timePass() {
		for(int i=1; i<=M; i++) {
			if(repairDesks[i].customer != null) {
				repairDesks[i].remainedTime--;
				if(repairDesks[i].remainedTime == 0) {
					finishedList.add(repairDesks[i].customer);
					repairDesks[i].customer = null;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			if(receptionDesks[i].customer != null) {
				receptionDesks[i].remainedTime--;
				if(receptionDesks[i].remainedTime == 0) {
					repairWaiting.offer(receptionDesks[i].customer);
					receptionDesks[i].customer = null;
				}
			}
		}
		while(!repairWaiting.isEmpty()) {
			boolean flag = true;
			for(int i=1; i<=M; i++) {
				if(repairDesks[i].customer == null) {
					repairDesks[i].customer = repairWaiting.poll();;
					repairDesks[i].remainedTime = repairDesks[i].time;
					repairDesks[i].customer.repair = i;
					flag = false;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		while(!receptionWaiting.isEmpty() && receptionWaiting.peek().arrivedTime <= time) {
			boolean flag = true;
			for(int i=1; i<=N; i++) {
				if(receptionDesks[i].customer == null) {
					receptionDesks[i].customer = receptionWaiting.poll();;
					receptionDesks[i].remainedTime = receptionDesks[i].time;
					receptionDesks[i].customer.reception = i;
					flag = false;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		time++;
	}
}
