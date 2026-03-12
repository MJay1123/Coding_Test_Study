import java.io.*;
import java.util.*;
 
public class Solution {
	static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        TreeSet<Long> ts = new TreeSet<>(Collections.reverseOrder());
        for (int testCase = 1; testCase <= T; testCase++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
            String str = br.readLine();
            int length = N / 4;
            for(int i=0; i<length; i++) {
            	str += str.charAt(i);
            }
            ts.clear();
            for(int i=0; i<length; i++) {
            	for(int j=i; j<N; j+=length) {
            		long temp = Long.parseLong(str.substring(j, j+length), 16);
            		ts.add(temp);
            	}
            }
            for(int i=0; i<K-1; i++) {
            	ts.pollFirst();
            }
            long answer = ts.pollFirst();
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}