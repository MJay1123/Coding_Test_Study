import java.util.*;
import java.io.*;
class Solution {
    static int N, B, E;
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int x = Integer.parseInt(st.nextToken());
                if(check(x)){
                    answer++;
                }
            }
            sb.append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
    public static boolean check(int x){
        int sum = 0;
        while(true){
            sum += x;
            if(B-E <= sum && sum <= B+E){
                return true;
            }
            if(sum > B+E){
                break;
            }
        }
        return false;
    }
}