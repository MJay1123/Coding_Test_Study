import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++) {
			int testCase = Integer.parseInt(br.readLine());
			sb.append("#").append(test_case).append(" ");
			Queue<Integer> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int minusNum = 5;
			while(true) {
				minusNum = minusNum % 5 + 1;
				int number = queue.poll();
				if(number - minusNum <= 0) {
					number = 0;
					queue.offer(number);
					break;
				}
				number -= minusNum;
				queue.offer(number);
			}
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
            sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}