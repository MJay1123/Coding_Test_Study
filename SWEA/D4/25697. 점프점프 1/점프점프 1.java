import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            if(X < 0){
                X = -X;
            }
            int[] distance = new int[N];
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                distance[i] = Integer.parseInt(st.nextToken());
                sum += distance[i];
            }
			long answer = getCount(distance, sum, X);
            bw.write(answer + "\n");
		}
        bw.flush();
	}
    public static long getCount(int[] distance, long sum, int X){
        if(X == 0){
			return 0;
        }
        if(sum == 0){
            return -1;
        }
        long left = distance[0];
        long right = distance[0];
        long count = 1;
        int index = 1 % distance.length;
        if(sum < X) {
        	count = X / sum * distance.length;
        	index = 0;
            left = (long)distance[0] - (X / sum * sum - distance[0]);
            right = X / sum * sum;
        }
        while(true){
            if(left <= X && right >= X){
                break;
            }
            if(distance[index] < left){
                left -= distance[index];
                right += distance[index];
            } else if(distance[index] >= left && distance[index] <= right){
                left = 0;
                right += distance[index];
            } else {
                left = distance[index] - right;
                right += distance[index];
            }
            count++;
            index = (index+1) % distance.length;
        }
        return count;
    }
}
