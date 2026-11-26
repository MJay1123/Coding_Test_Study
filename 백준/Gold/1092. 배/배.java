import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] cranes = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] boxes = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(boxes);
		int[] targets = new int[N];
		Arrays.fill(targets, -1);
		for(int i=0; i<N; i++){
			for(int j=M-1; j>=0; j--) {
				if(cranes[i] >= boxes[j]) {
					targets[i] = j;
					break;
				}
			}
		}
		int count = 0;
		int answer = -1;
		boolean[] visited = new boolean[M];
		for(int time=1; time<=M; time++){
			if(answer != -1){
				break;
			}
			for(int i=0; i<N; i++) {
				int target = targets[i];
				while(target >= 0 && visited[target]) {
					target--;
				}
				if(target == -1) {
					continue;
				}
				visited[target] = true;
				targets[i] = target;
				count++;
				if(count == M) {
					answer = time;
					break;
				}
			}
		}
		bw.write(answer + "\n");
		bw.flush();
	}
}
