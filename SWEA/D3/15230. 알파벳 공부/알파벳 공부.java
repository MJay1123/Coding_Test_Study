import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++){
            String str = br.readLine();
            int answer = 0;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) - 'a' == i){
                    answer++;
                } else {
                    break;
                }
            }
            sb.append(String.format("#%d %d\n", tc, answer));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}