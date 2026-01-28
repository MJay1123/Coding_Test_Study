import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int[][] arr = new int[9][9];
            int[][] rowCount = new int[9][10];
            int[][] columnCount = new int[9][10];
            boolean[] possible = new boolean[3];
            for(int i=0; i<3; i++){
                possible[i] = true;
            }
			for(int r=0; r<9; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<9; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
                    rowCount[r][arr[r][c]]++;
                    if(rowCount[r][arr[r][c]] > 1){
                        possible[0] = false;
                    }
                    columnCount[c][arr[r][c]]++;
                    if(columnCount[c][arr[r][c]] > 1){
                        possible[0] = false;
                    }
				}
			}
            int[] boxIndex = {0, 3, 6};
            possible[2] = true;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(!checkBox(arr, boxIndex[i], boxIndex[j])){
                        possible[2] = false;
                    }
                }
            }
            int answer = 0;
            if(possible[0] && possible[1] && possible[2]){
				answer = 1;
			}
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
	public static boolean checkBox(int[][] arr, int r, int c) {
		int[] count = new int[10];
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				count[arr[i][j]]++;
				if(count[arr[i][j]] > 1) {
					return false;
				}
			}
		}
		return true;
	}
}