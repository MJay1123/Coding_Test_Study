import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int K = Integer.parseInt(br.readLine());
			int[][] magnets = new int[5][8];
			for(int i=1; i<=4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken());	// N : 0, S : 1
				}
			}
			for(int k=0; k<K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int magnetNum = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());	// 1 : 시계방향, -1 : 반시계방향
				int[] rotation = new int[5];
				rotation[magnetNum] = direction;
				// 오른쪽 자석들의 맞물리는 극 판별
				for(int i=magnetNum+1; i<=4; i++) {
					int indexR = magnets[0][i];
					int indexL = magnets[0][i-1];
					if(magnets[i-1][(indexL + 2)%8] == magnets[i][(indexR+6)%8]) {
						break;
					}
					rotation[i] = -rotation[i-1];
				}
				// 왼쪽 자석들의 맞물리는 극 판별
				for(int i=magnetNum-1; i>=1; i--) {
					int indexL = magnets[0][i];
					int indexR = magnets[0][i+1];
					if(magnets[i][(indexL+2)%8] == magnets[i+1][(indexR+6)%8]) {
						break;
					}
					rotation[i] = -rotation[i+1];
				}
				// 자석들 회전
				for(int i=1; i<=4; i++) {
					if(rotation[i] != 0) {
						rotate(magnets, i, rotation[i]);
					}
				}
			}
			int answer = 0;
			for(int i=1; i<=4; i++) {
				int index = magnets[0][i];
				if(magnets[i][index] == 1) {
					answer += (int)Math.pow(2, i-1);
				}
			}
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static int[] getRotation(int magnetNum, int direction) {
		int[] rotation = new int[5];
		if(magnetNum % 2 == 0) {
			rotation[0] = direction;
			rotation[2] = direction;
			rotation[1] = -direction;
			rotation[3] = -direction;
		} else {
			rotation[0] = -direction;
			rotation[2] = -direction;
			rotation[1] = direction;
			rotation[3] = direction;
		}
		return rotation;
	}
	public static void rotate(int[][] magnets, int magnetNum, int direction) {
		if(direction == 0) {
			return;
		}
		magnets[0][magnetNum] = (magnets[0][magnetNum] - direction + 8) % 8;
	}
}