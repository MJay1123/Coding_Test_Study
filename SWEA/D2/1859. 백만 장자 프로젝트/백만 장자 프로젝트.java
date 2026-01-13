import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Stack<Integer> priceStack = new Stack<>();
            Stack<Integer> indexStack = new Stack<>();
            priceStack.push(arr[N-1]);
            indexStack.push(N-1);
            for(int i=N-2; i>=0; i--){
                if(arr[i] > priceStack.peek()){
                    priceStack.push(arr[i]);
                    indexStack.push(i);
                }
            }
            long answer = 0;
            int start = 0;
            while(!priceStack.isEmpty()){
                int price = priceStack.pop();
                int index = indexStack.pop();
                for(int i=start; i<index; i++){
                    answer += (price - arr[i]);
                }
                start = index + 1;
            }
            bw.write("#" + test_case + " " + answer + "\n");
		}
        bw.flush();
	}
}