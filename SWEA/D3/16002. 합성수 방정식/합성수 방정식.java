import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            for(int i=2; i<=1000000000; i++){
                if(check(i+N) && check(i)){
                    answer = i;
                    break;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer+N).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static boolean check(int num){
        for(int i=2; i<num; i++){
            if(num % i == 0){
                return true;
            }
        }
        return false;
    }
}