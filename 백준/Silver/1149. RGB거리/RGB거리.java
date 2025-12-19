import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] minimumCost = new int[N][3];
        for(int i=0; i<3; i++){
            minimumCost[0][i] = cost[0][i];
        }
        for(int i=1; i<N; i++){
            minimumCost[i][0] = Math.min(minimumCost[i-1][1], minimumCost[i-1][2]) + cost[i][0];
            minimumCost[i][1] = Math.min(minimumCost[i-1][0], minimumCost[i-1][2]) + cost[i][1];
            minimumCost[i][2] = Math.min(minimumCost[i-1][0], minimumCost[i-1][1]) + cost[i][2];
        }
        int answer = Math.min(Math.min(minimumCost[N-1][0], minimumCost[N-1][1]), minimumCost[N-1][2]);
        bw.write(answer + "\n");
        bw.flush();
    }
}
