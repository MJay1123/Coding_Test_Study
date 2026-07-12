import java.util.*;
import java.io.*;
public class Solution {
    static double p, q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Double.parseDouble(st.nextToken());
            q = Double.parseDouble(st.nextToken());
            double s1 = (1-p)*q;
            double s2 = p*(1-q)*q;
            sb.append("#").append(tc).append(" ");
            if(s1 < s2){
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}