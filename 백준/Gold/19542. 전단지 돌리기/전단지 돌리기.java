import java.util.*;
import java.io.*;

public class Main {
    static int N, S, D;
    static List<Integer>[] adj;
    static int[] maxDist; // 각 노드에서 하위 리프까지의 최대 거리
    static int totalDistance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        maxDist = new int[N + 1];
        
        // 1. S부터 시작하여 각 노드의 하위 최대 깊이(거리)를 구함
        dfs(S, -1);
        
        // 2. 다시 탐색하며 maxDist가 D 이상인 노드로 이동하는 경로 계산
        // S는 시작점이므로 제외하고, 나머지 노드 중 maxDist[i] >= D인 곳의 개수 * 2
        for (int i = 1; i <= N; i++) {
            if (i != S && maxDist[i] >= D) {
                totalDistance += 2;
            }
        }

        System.out.println(totalDistance);
    }

    static int dfs(int curr, int prev) {
        int maxH = 0;
        for (int next : adj[curr]) {
            if (next == prev) continue;
            // 자식 노드들 중 가장 먼 거리를 가져옴
            maxH = Math.max(maxH, dfs(next, curr) + 1);
        }
        return maxDist[curr] = maxH;
    }
}