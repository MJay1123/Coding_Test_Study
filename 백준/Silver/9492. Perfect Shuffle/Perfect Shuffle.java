import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                break;
            }
            Queue<String> leftCards = new LinkedList<>();
			Queue<String> rightCards = new LinkedList<>();
			for(int i=0; i<(N-1)/2+1; i++) {
				leftCards.offer(br.readLine());
			}
			for(int i=(N-1)/2+1; i<N; i++) {
				rightCards.offer(br.readLine());
            }
			while(!rightCards.isEmpty()) {
				sb.append(leftCards.poll()).append("\n");
				sb.append(rightCards.poll()).append("\n");
			}
			if(!leftCards.isEmpty()) {
				sb.append(leftCards.poll()).append("\n");
			}
        }
		bw.write(sb.toString());
        bw.flush();
	}
}