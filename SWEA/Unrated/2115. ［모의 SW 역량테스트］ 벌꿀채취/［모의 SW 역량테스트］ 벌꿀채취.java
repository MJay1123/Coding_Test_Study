import java.util.*;
import java.io.*;

class Solution {
    static int N, M, C;
    static int tempSum = 0;
    static int answer = 0;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for(int r=0; r<N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++){
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
            int[][] selected = new int[2][2];
            C(0, 0, arr, 0, selected);
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
    public static void getSum(int[] arrA, int[] arrB) {
    	int sumOfTwo = 0;
    	tempSum = 0;
    	boolean[] visited = new boolean[M];
    	getHoney(arrA, 0, 0, visited);
    	sumOfTwo += tempSum;
    	
    	tempSum = 0;
    	visited = new boolean[M];
    	getHoney(arrB, 0, 0, visited);
    	sumOfTwo += tempSum;
    	
    	answer = Math.max(answer, sumOfTwo);
    }
    public static void getHoney(int[] arr, int index, int sum, boolean[] visited){
    	if(sum > C) {
    		return;
    	}
        if(index == M) {
        	int result = 0;
        	for(int i=0; i<M; i++) {
        		if(visited[i]) {
        			result += arr[i] * arr[i];
        		}
        	}
        	tempSum = Math.max(tempSum, result);
        	return;
        }
        visited[index] = true;
        getHoney(arr, index+1, sum + arr[index], visited);
        visited[index] = false;
        getHoney(arr, index+1, sum, visited);        
    }
    public static boolean check(int[][] arr, int[][] selected){
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                int r1 = selected[0][0];
                int c1 = selected[0][1]+i;
                int r2 = selected[1][0];
                int c2 = selected[1][1]+j;
                if(!checkRange(r1, c1) || !checkRange(r2, c2) || (r1 == r2 && c1 == c2)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void C(int r, int c, int[][] arr, int depth, int[][] selected){
        if(depth == 2){
            if(check(arr, selected)) {
            	int[] arrA = new int[M];
            	int[] arrB = new int[M];
            	for(int i=0; i<M; i++) {
            		arrA[i] = arr[selected[0][0]][selected[0][1]+i];
            		arrB[i] = arr[selected[1][0]][selected[1][1]+i];
            	}
            	getSum(arrA, arrB);
            }
            return;
        }
        if(!checkRange(r, c)){
            return;
        }
        selected[depth][0] = r;
        selected[depth][1] = c;
        int nr = r;
        int nc = c+1;
        if(nc == N){
            nc = 0;
            nr++;
        }
        C(nr, nc, arr, depth+1, selected);
        C(nr, nc, arr, depth, selected);
    }
    public static boolean checkRange(int r, int c){
    	return r >= 0 && r < N && c >= 0 && c < N;
    }
}