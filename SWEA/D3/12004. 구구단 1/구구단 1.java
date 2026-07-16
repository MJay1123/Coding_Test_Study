import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            int num = Integer.parseInt(br.readLine());
            if(check(num)){
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static boolean check(int num){
        for(int a=1; a<=9; a++){
            for(int b=1; b<=9; b++){
                if(a * b == num){
                    return true;
                }
            }
        }
        return false;
    }
}