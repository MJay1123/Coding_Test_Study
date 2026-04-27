import java.util.*;
class Solution {
    static List<Integer>[] connectedTo, connectedFrom;
    static int N = 0;
    static boolean[] visited;
    public int[] solution(int[][] edges) {
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            N = Math.max(N, Math.max(a, b));
        }
        connectedTo = new List[N+1];
        connectedFrom = new List[N+1];
        for(int i=1; i<=N; i++){
            connectedTo[i] = new ArrayList<>();
            connectedFrom[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            connectedTo[a].add(b);
            connectedFrom[b].add(a);
        }
        int createdNum = -1;
        for(int i=1; i<=N; i++){
            if(connectedFrom[i].size() == 0 && connectedTo[i].size() >= 2){
                createdNum = i;
                break;
            }
        }
        int[] answer = new int[4];
        answer[0] = createdNum;
        visited = new boolean[N+1];
        visited[createdNum] = true;
        for(int i : connectedTo[createdNum]){
            int index = BFS(i);
            answer[index]++;
        }
        return answer;
    }
    public static int BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(connectedTo[current].size() == 0){
                return 2;
            }
            if(connectedTo[current].size() > 1){
                return 3;
            }
            for(int next : connectedTo[current]){
                if(visited[next]){
                    return 1;
                } else {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return 1;
    }
}