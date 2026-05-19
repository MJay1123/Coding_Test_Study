import java.util.*;
import java.io.*;
class Solution {
    static Character[][] arr;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            arr = new Character[5][15];
            for(int r=0; r<5; r++){
            	String str = br.readLine();
                for(int c=0; c<str.length(); c++){
                    arr[r][c] = str.charAt(c);
                }
            }
            sb.append("#").append(testCase).append(" ");
            for(int c=0; c<15; c++){
                for(int r=0; r<5; r++){
                    if(arr[r][c] != null){
                    	sb.append(arr[r][c]);
                    }
                }
            }
            sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}