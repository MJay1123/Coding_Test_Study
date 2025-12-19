import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int number;
        int distance;
        public Node(int number, int distance){
            this.number = number;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o){
            return this.distance - o.distance;
        }
    }
    static int N;
    static int E;
    static int[][] primeDistance = new int[2][2];       // 1, N, v1, v2 사이의 거리
    static int betweenDistance = 0;                     // v1, v2 사이의 거리
    static int[] minimumDistance;
    static boolean[] visited;
    static List<HashMap<Integer, Integer>> distanceList = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for(int i=0; i<=N; i++){
            distanceList.add(new HashMap<Integer, Integer>());
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distanceList.get(a).put(b, c);
            distanceList.get(b).put(a, c);
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 문제 풀이
        minimumDistance = new int[N+1];
        for(int i=0; i<=N; i++){
            minimumDistance[i] = Integer.MAX_VALUE;
        }
        dijkstra(1);
        primeDistance[0][0] = minimumDistance[v1];
        primeDistance[0][1] = minimumDistance[v2];
        dijkstra(N);
        primeDistance[1][0] = minimumDistance[v1];
        primeDistance[1][1] = minimumDistance[v2];
        dijkstra(v1);
        betweenDistance = minimumDistance[v2];
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                if(primeDistance[i][j] == Integer.MAX_VALUE){
                    answer = -1;
                }
            }
        }
        if(betweenDistance == Integer.MAX_VALUE){
            answer = -1;
        }
        if(answer != -1) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(primeDistance[0][0] + betweenDistance + primeDistance[1][1]);
            pq.offer(primeDistance[0][1] + betweenDistance + primeDistance[1][0]);
            pq.offer(primeDistance[0][0] + betweenDistance * 2 + primeDistance[1][0]);
            pq.offer(primeDistance[0][1] + betweenDistance * 2 + primeDistance[1][1]);
            answer = pq.poll();
        }
        bw.write(answer + "\n");
        bw.flush();
    }

    static void dijkstra(int start){
        minimumDistance = new int[N+1];
        for(int i=1; i<=N; i++){
            minimumDistance[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[N+1];
        visited[start] = true;
        minimumDistance[start] = 0;
        Node node = new Node(start, 0);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(node);
        while(!pq.isEmpty()){
            node = pq.poll();
            start = node.number;
            visited[start] = true;
            HashMap<Integer, Integer> hm = distanceList.get(start);
            for(int i : hm.keySet()){
                int next = i;
                int dist = hm.get(i);
                if(!visited[next]) {
                    if (minimumDistance[next] > minimumDistance[start] + dist) {
                        minimumDistance[next] = minimumDistance[start] + dist;
                        node = new Node(next, minimumDistance[next]);
                        pq.offer(node);
                    }
                }
            }
        }
    }
}
