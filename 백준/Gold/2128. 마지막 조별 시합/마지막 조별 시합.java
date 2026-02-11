import java.util.*;
import java.io.*;

public class Main {
	static int N, D, K;
	static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        List<Integer> bitList = new ArrayList<>();
        for(int i=0; i<(1<<15); i++) {
        	if(Integer.bitCount(i) == K) {
        		bitList.add(i);
        	}
        }
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int count = Integer.parseInt(st.nextToken());
        	int bit = 0;
        	for(int j=0; j<count; j++) {
        		int problemNum = Integer.parseInt(st.nextToken());
        		bit = bit | (1 << problemNum-1);
        	}
        	arr[i] = bit;
        }
        int answer = 0;
        for(int i=0; i<bitList.size(); i++) {
        	int bit = bitList.get(i);
        	int count = 0;
        	for(int j=0; j<N; j++) {
        		if((bit & arr[j]) == arr[j]) {
        			count++;
        		}
        	}
        	answer = Math.max(answer, count);
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}