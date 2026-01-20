import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            int[] B = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
            char[] team = new char[N+1];
            for(int i=0; i<N/2 + 1; i++){
                scout('A', A, team);
                scout('B', B, team);
            }
			StringBuilder sb = new StringBuilder();
            for(int i=1; i<=N; i++){
            	sb.append(team[i]);
            }
            sb.append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
    public static void scout(char ch, int[] arr, char[] team){
        for(int i=0; i<arr.length; i++){
            int index = arr[i];
            if(team[index] != 'A' && team[index] != 'B'){
                team[index] = ch;
                return;
            }
        }
    }
}