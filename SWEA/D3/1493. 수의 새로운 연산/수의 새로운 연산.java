import java.util.*;
import java.io.*;
public class Solution {
    static int p, q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            int[] ploc = getLocation(p);
            int[] qloc = getLocation(q);
            int answer = getNumber(ploc[0] + qloc[0], ploc[1] + qloc[1]);
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int[] getLocation(int num){
        int[] result = new int[2];
        int sum = 0;
        int n = 0;
        while(sum < num){
            n++;
            sum += n;
        }
        int y = sum - num + 1;
        int x = n + 1 - y;
        result[0] = x;
        result[1] = y;
        return result;
    }
    public static int getNumber(int x, int y){
        int sum = x + y;
        int startNum = (sum-2) * (sum-1) / 2;
        return startNum + x;
    }
}