import java.util.*;
import java.io.*;
public class Solution {
    static int N, START;
    static boolean[][] connection;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=10; tc++){
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            START = Integer.parseInt(st.nextToken());
            connection = new boolean[101][101];
            visited = new boolean[101];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                connection[from][to] = true;
            }
            int answer = BFS(START);
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int BFS(int start){
        List<Integer> list = new ArrayList<>();
        int depth = 0;
        Queue<Integer> numQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        list.add(start);
        numQueue.offer(start);
        depthQueue.offer(0);
        visited[start] = true;
        while(!numQueue.isEmpty()){
            int cn = numQueue.poll();
            int cd = depthQueue.poll();
            for(int nn=1; nn<=100; nn++){
                if(connection[cn][nn] && !visited[nn]){
					int nd = cd + 1;
                    if(nd == depth + 1){
                        list.clear();
                        depth++;
                    }
                    list.add(nn);
                    numQueue.offer(nn);
                    depthQueue.offer(nd);
                    visited[nn] = true;
                }
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}