import java.util.*;
import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int n=0; n<N; n++) {
			String word = br.readLine();
			for(int i=0; i<word.length(); i++) {
				char ch = word.charAt(i);
				hm.put(ch, hm.getOrDefault(ch, 0) + (int)(Math.pow(10, word.length()-1-i)));
			}
		}
		int[] arr = new int[hm.size()];
		int index = 0;
		for(char ch : hm.keySet()) {
			arr[index++] = hm.get(ch);
		}
		Arrays.sort(arr);
		int num = 9;
		int answer = 0;
		for(int i=arr.length-1; i>=0; i--) {
			answer += (num--) * arr[i];
		}
		bw.write(answer + "\n");
		bw.flush();
	}
}
