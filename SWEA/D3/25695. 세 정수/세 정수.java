import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());
            int A = 1;
            int B = 1;
            int C = 1;
            int[] arr = new int[3];
            arr[0] = X;
            arr[1] = Y;
            arr[2] = Z;
            Arrays.sort(arr);
            if(arr[0] == arr[2]){
                A = arr[0];
                B = arr[0];
                C = arr[0];
            } else if(arr[1] != arr[2]){
                A = -1;
                B = -1;
                C = -1;
            } else {
                if(X == Y){
                    B = arr[2];
                    A = arr[0];
                    C = arr[0];
                } else if(X == Z){
                    A = arr[2];
                    B = arr[0];
                    C = arr[0];
                } else {
                    C = arr[2];
                    A = arr[0];
                    B = arr[0];
                }
            }
            bw.write(A + " " + B + " " + C + "\n");
		}
        bw.flush();
	}
}