import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean answer = true;
            for(int i=0; i<N; i++){
                if((M & 1) == 0){
                    answer = false;
                    break;
                }
                M = (M >> 1);
            }
            sb.append("#").append(tc).append(" ");
            if(answer){
                sb.append("ON");
            } else {
                sb.append("OFF");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
    	bw.flush();
    }
}