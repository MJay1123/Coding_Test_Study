import java.util.*;
import java.io.*;
class Solution {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[2 * N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<2*N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[2*N];
            sb.append("#").append(testCase).append(" ");
            for(int i=0; i<2*N; i++){
                if(!visited[i]){
                    for(int j=i+1; j<2*N; j++){
                        if(!visited[j] && arr[i] / 3 * 4 == arr[j]){
                            visited[i] = true;
                            visited[j] = true;
                            sb.append(arr[i]).append(" ");
                            break;
                        }
                    }
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}