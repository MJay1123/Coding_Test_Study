import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
            int[] whitePaper = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                whitePaper[i] = Integer.parseInt(st.nextToken());	// {x1, y1, x2, y2}
            }
            int[][] blackPapers = new int[2][4];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                blackPapers[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                blackPapers[1][i] = Integer.parseInt(st.nextToken());
            }
            if(check(whitePaper, blackPapers)){
                sb.append("NO");
            } else {
                sb.append("YES");
            }
            sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
    public static boolean contains(int[] whitePaper, int[] blackPaper){
        if(blackPaper[0] <= whitePaper[0] && blackPaper[1] <= whitePaper[1] && blackPaper[2] >= whitePaper[2] && blackPaper[3] >= whitePaper[3]){
            return true;
        }
        return false;
    }
    public static boolean check(int[] whitePaper, int[][] blackPapers) {
        if(contains(whitePaper, blackPapers[0]) || contains(whitePaper, blackPapers[1])){
            return true;
        }
        if(blackPapers[0][0] <= whitePaper[0] && blackPapers[1][0] <= whitePaper[0] && blackPapers[0][2] >= whitePaper[2] && blackPapers[1][2] >= whitePaper[2]){
            if(check2(whitePaper[1], whitePaper[3], blackPapers[0][1], blackPapers[0][3], blackPapers[1][1], blackPapers[1][3])){
                return true;
            }
        }
        if(blackPapers[0][1] <= whitePaper[1] && blackPapers[1][1] <= whitePaper[1] && blackPapers[0][3] >= whitePaper[3] && blackPapers[1][3] >= whitePaper[3]){
            if(check2(whitePaper[0], whitePaper[2], blackPapers[0][0], blackPapers[0][2], blackPapers[1][0], blackPapers[1][2])){
                return true;
            }
        }
        return false;
    }
    public static boolean check2(int whiteLeft, int whiteRight, int left1, int right1, int left2, int right2){
        int maxLeft = Math.max(left1, left2);
        int minLeft = Math.min(left1, left2);
        int maxRight = Math.max(right1, right2);
        int minRight = Math.min(right1, right2);
        if(minLeft <= whiteLeft && whiteRight <= maxRight){
            if(minRight >= maxLeft){
                return true;
            }
        }
        return false;
    }
}