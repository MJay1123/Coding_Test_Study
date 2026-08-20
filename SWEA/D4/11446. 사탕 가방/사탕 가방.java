import java.util.*;
import java.io.*;
public class Solution {
    static int N;
    static long M;
    static long[] candies;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Long.parseLong(st.nextToken());
            candies = new long[N];
            st = new StringTokenizer(br.readLine());
            long low = 1;
            long high = 1;
            for(int i=0; i<N; i++){
                candies[i] = Long.parseLong(st.nextToken());
                high = Math.max(high, candies[i]);
            }
            long answer = 0;
            high = high + 1;
            while(low < high){
                long bagCount = (low + high) / 2;
//                System.out.println("bagCount : " + bagCount);
                long candyCount = 0;
                for(int i=0; i<N; i++){
                    candyCount += candies[i] / bagCount;
                    if(candyCount >= M) {
                    	break;
                    }
                }
//                System.out.println("candyCount : " + candyCount);
                if(candyCount >= M){
                    answer = Math.max(answer, bagCount);
                    low = bagCount + 1;
                } else {
                    high = bagCount;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}