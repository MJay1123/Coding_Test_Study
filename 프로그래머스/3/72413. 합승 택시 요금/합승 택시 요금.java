import java.util.*;
class Solution {
    class Connection implements Comparable<Connection> {
        int num;
        int distance;
        public Connection(int num, int distance){
            this.num = num;
            this.distance = distance;
        }
        @Override
        public int compareTo(Connection c){
            return this.distance - c.distance;
        }
    }
    int N, S, A, B;
    int MAX;
    List<int[]>[] connections;
    int[] distances;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        init(n, s, a, b, fares);
        int answer = MAX * 3;
        for(int i=1; i<=N; i++){
            int result = Math.min(answer, dijkstra(i));
            answer = Math.min(answer, result);
        }
        return answer;
    }
    public void init(int n, int s, int a, int b, int[][] fares){
        N = n;
        S = s;
        A = a;
        B = b;
        MAX = 100000 * N;
        connections = new List[N+1];
        for(int i=1; i<=N; i++){
            connections[i] = new ArrayList<>();
        }
        for(int i=0; i<fares.length; i++){
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            connections[c].add(new int[]{d,f});
            connections[d].add(new int[]{c,f});
        }
    }
    public int dijkstra(int start){
        PriorityQueue<Connection> pq = new PriorityQueue<>();
        distances = new int[N+1];
        Arrays.fill(distances, MAX);
        boolean[] visited = new boolean[N+1];
        pq.offer(new Connection(start, 0));
        distances[start] = 0;
        while(!pq.isEmpty()){
            Connection cc = pq.poll();
            int cn = cc.num;
            int cd = cc.distance;
            visited[cn] = true;
            if(visited[S] && visited[A] && visited[B]){
                return distances[S] + distances[A] + distances[B];
            }
            for(int[] arr : connections[cn]){
                int nn = arr[0];
                int nd = arr[1];
                if(visited[nn]){
                    continue;
                }
                if(distances[nn] > cd + nd){
                    distances[nn] = cd + nd;
                    pq.offer(new Connection(nn, distances[nn]));
                }
            }
        }
        return distances[S] + distances[A] + distances[B];
    }
}