import java.util.*;
import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int num = 0;
		for(int i=0; i<100; i++) {
			if(getLength(i) >= N) {
				num = i;
				break;
			}
		}
		char answer = getChar(num, N);
		bw.write(answer + "\n");
		bw.flush();
		
	}
	public static int getLength(int num) {
		if(num == 0) {
			return 3;
		} else {
			return getLength(num-1) * 2 + num + 3; 
		}
	}
	public static char getChar(int num, int index) {
		if(num == 0) {
			return "moo".charAt(index-1);
		} else {
			int prevL = getLength(num-1);
			if(index <= prevL) {
				return getChar(num-1, index);
			} else if(index > prevL + (num+3)) {
				return getChar(num-1, index - prevL - (num + 3));
			} else {
				if(index == prevL + 1) {
					return 'm';
				} else {
					return 'o';
				}
			}
		}
	}
}
