
// 바이러스
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int computer;
    static int connection;
    static boolean[][] connections;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        computer = Integer.parseInt(br.readLine());
        connection = Integer.parseInt(br.readLine());

        connections = new boolean[computer+1][computer+1];
        for(int i=0; i<connection; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connections[a][b] = connections[b][a] = true;
        }

        visited = new boolean[computer+1];

        dfs(1);
        bw.write(count-1 + "\n");
        bw.flush();
    }

    public static void dfs(int start){
        count++;
        visited[start] = true;
        for(int i=1; i<=computer; i++){
            if(!visited[i] && connections[start][i]){
                dfs(i);
            }
        }
    }
}
