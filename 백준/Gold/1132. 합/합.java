import java.util.*;
import java.io.*;

public class Main {
	static class Alphabet implements Comparable<Alphabet> {
		char ch;
		long number;
		boolean canZero;
		public Alphabet(char ch, long number, boolean canZero) {
			this.ch = ch;
			this.number = number;
			this.canZero = canZero;
		}
		@Override
		public int compareTo(Alphabet a) {
			return Long.compare(this.number, a.number);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		PriorityQueue<Alphabet> pq = new PriorityQueue<>();
		for(char ch = 'A'; ch <= 'J'; ch++) {
			Alphabet al = new Alphabet(ch, 0, true);
			for(String str : arr) {
				if(str.charAt(0) == ch) {
					al.canZero = false;
				}
				long result = check(str, ch);
				al.number += result;
			}
			pq.offer(al);
		}
		boolean zeroUsed = false;
		long answer = 0;
		int number = 1;
		while(!pq.isEmpty()) {
			Alphabet al = pq.poll();
			if(!zeroUsed) {
				if(al.canZero) {
					answer += al.number * 0;
					zeroUsed = true;
				} else {
					answer += al.number * number;
					number++;
				}
			} else {
				answer += al.number * number;
				number++;
			}
		}
		bw.write(answer + "\n");
		bw.flush();
	}
	public static long check(String str, char ch) {
		long result = 0;
		long temp = 1;
		for(int i=0; i<str.length(); i++) {
			int index = str.length() - 1 - i;
			if(str.charAt(index) == ch) {
				result += temp;
			}
			temp *= 10;
		}
		return result;
	}

}
