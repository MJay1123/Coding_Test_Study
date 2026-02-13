import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] lamps;
    static HashMap<Long, Integer> countOfBits = new HashMap<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long[] bits = new long[N];
        for(int r=0; r<N; r++){
            String str = br.readLine();
            bits[r] = Long.parseLong(str, 2);
            countOfBits.put(bits[r], countOfBits.getOrDefault(bits[r], 0) + 1);
        }
        K = Integer.parseInt(br.readLine());
        int answer = 0;
        for(long bit : countOfBits.keySet()) {
        	int zeroCount = M - Long.bitCount(bit);
        	if(zeroCount <= K && (K - zeroCount) % 2 == 0) {
        		answer = Math.max(answer,  countOfBits.get(bit));
        	}
        }
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}