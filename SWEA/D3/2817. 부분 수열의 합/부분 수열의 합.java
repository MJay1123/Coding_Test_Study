import java.util.*;
import java.io.*;
public class Solution {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int answer = 0;
            for(int bit=0; bit<(1 << N); bit++){
                int sum = 0;
                for(int d=0; d<N; d++){
                    if((bit & (1 << d)) > 0){
                        sum += arr[d];
                        if(sum > K){
                            break;
                        }
                    }
                }
                if(sum == K){
                    answer++;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}