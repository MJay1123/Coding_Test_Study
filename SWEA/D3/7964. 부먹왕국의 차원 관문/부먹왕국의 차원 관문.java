import java.util.*;
import java.io.*;
public class Solution {
    static int N, D;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            int length = 0;
            int answer = 0;
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] == 0){
                    length++;
                } else {
                    answer += (length / D);
                    length = 0;
                }
            }
            answer += (length / D);
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}