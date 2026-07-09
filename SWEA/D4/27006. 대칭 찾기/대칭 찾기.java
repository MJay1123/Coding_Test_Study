import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static char[][] arr1;
	static char[][] arr2;
	static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++){
        	answer = 0;
        	N = Integer.parseInt(br.readLine());
        	arr1 = new char[N][N];
        	arr2 = new char[N][N];
        	for(int r=0; r<N; r++) {
        		String str = br.readLine();
        		for(int c=0; c<N; c++) {
        			arr1[r][c] = str.charAt(c);
        		}
        	}
        	for(int d=0; d<N; d++) {
        		for(int r=0; r<N; r++) {
        			for(int c=0; c<N; c++) {
        				arr2[r][c] = arr1[r][(c+d)%N];
        			}
        		}
        		if(check(arr2)) {
        			answer++;
        		}
        	}
        	answer *= N;
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    
    public static boolean check(char[][] arr) {
    	for(int r=0; r<N; r++) {
    		for(int c=0; c<N; c++) {
    			if(arr[r][c] != arr[c][r]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}