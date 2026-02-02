import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> password = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				password.add(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for(int j=0; j<count; j++) {
					password.add(index++, Integer.parseInt(st.nextToken()));
				}
			}
			sb.append("#").append(test_case).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(password.get(i)).append(" ");
			}
            sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}