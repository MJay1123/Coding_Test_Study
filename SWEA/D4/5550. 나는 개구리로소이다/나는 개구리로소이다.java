import java.util.*;
import java.io.*;
public class Solution {
    static int[] count;
    static char[] crawl = {'c', 'r', 'o', 'a', 'k'};
    static int answer;
    public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            String str = br.readLine();
            count = new int[5];
         	answer = 0;
            for(int i=0; i<str.length(); i++){
                add(str.charAt(i));
                if(!check()){
                    answer = -1;
                    break;
                }
            }
            if(count[0] > 0){
                answer = -1;
            }
            sb.append(String.format("#%d %d\n", testCase, answer));
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void add(char ch){
        for(int i=0; i<5; i++){
            if(ch == crawl[i]){
                count[i]++;
                answer = Math.max(answer, count[i]);
                return;
            }
        }
    }
    public static boolean check() {
        for(int i=0; i<4; i++){
            if(count[i] < count[i+1]){
                return false;
            }
        }
        if(count[4] == 1){
            for(int i=0; i<5; i++){
                count[i]--;
            }
        }
        return true;
    }
}