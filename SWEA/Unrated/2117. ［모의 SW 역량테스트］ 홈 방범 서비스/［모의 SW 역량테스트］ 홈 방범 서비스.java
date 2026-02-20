import java.util.*;
import java.io.*;
 
public class Solution {
	static int N, M;
	static int[][] map;
	static int[][][] arr;
	static int[] maxHouseCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            List<Integer> homeList = new ArrayList<>();
            for(int r=0; r<N; r++) {
            	st = new StringTokenizer(br.readLine());
            	for(int c=0; c<N; c++) {
            		map[r][c] = Integer.parseInt(st.nextToken());
            		if(map[r][c] == 1) {
            			homeList.add(r * 100 + c);
            		}
            	}
            }
            arr = new int[N+2][N][N];
            maxHouseCount = new int[N+2];
            for(int k=1; k<=N+1; k++) {
            	for(int home : homeList) {
            		int hr = home / 100;
            		int hc = home % 100;
            		for(int r=0; r<N; r++) {
            			for(int c=0; c<N; c++) {
            				if(distance(hr, hc, r, c) <= k) {
            					arr[k][r][c]++;
            					maxHouseCount[k] = Math.max(maxHouseCount[k],  arr[k][r][c]);
            				}
            			}
            		}            		
            	}
            }
            int answer = 0;
            for(int i=1; i<=N+1; i++) {
            	int income = M * maxHouseCount[i];
            	int outcome = i * i + (i-1)*(i-1);
            	if(income >= outcome) {
            		answer = maxHouseCount[i];
            	}
            }
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int distance(int r1, int c1, int r2, int c2) {
    	return Math.abs(r1 - r2) + Math.abs(c1 - c2) + 1;
    }
}
