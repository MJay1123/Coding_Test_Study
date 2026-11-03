import java.util.*;
class Solution {
    static class Pipe {
        int num;
        int pipe;
        public Pipe(int num, int pipe){
            this.num = num;
            this.pipe = pipe;
        }
    }
    static List<Pipe>[] pipes;
    static int[] parents;
    static int[] counts;
    static boolean[] infected;
    static List<int[]> list = new ArrayList<>();
    public static void combination(int depth, int[] result, int k){
        if(depth == k){
            int[] arr = new int[k];
            for(int i=0; i<k; i++){
                arr[i] = result[i];
            }
            list.add(arr);
            return;
        }
        result[depth] = 1;
        combination(depth+1, result, k);
        result[depth] = 2;
        combination(depth+1, result, k);
        result[depth] = 3;
        combination(depth+1, result, k);
    }
    public int solution(int n, int infection, int[][] edges, int k) {
        pipes = new List[n+1];
        for(int i=1; i<=n; i++){
            pipes[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            int pipe = edges[i][2];
            pipes[n1].add(new Pipe(n2, pipe));
            pipes[n2].add(new Pipe(n1, pipe));
        }
        int answer = 0;
        combination(0, new int[k], k);
        for(int[] sequence : list){
            init(n, infection);
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<k; i++){
                int opened = sequence[i];
                for(int j=1; j<=n; j++){
                    if(infected[j]){
                        queue.add(j);
                    }
                    while(!queue.isEmpty()){
                        int inf = queue.poll();
                        for(Pipe pipe : pipes[inf]){
                            if(pipe.pipe == opened){
                                if(union(inf, pipe.num)){
                                    queue.offer(pipe.num);
                                }
                            }
                        }
                    }
                }
            }
            answer = Math.max(answer, counts[infection]);
        }
        return answer;
    }
    public static void init(int n, int infection){
        parents = new int[n+1];
        counts = new int[n+1];
        for(int i=1; i<=n; i++){
            parents[i] = i;
            counts[i] = 1;
        }
        infected = new boolean[n+1];
        infected[infection] = true;
    }
    public static boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2){
            return false;
        }
        parents[p2] = p1;
        counts[p1] += counts[p2];
        counts[p2] = 0;
        infected[p2] = true;
        return true;
    }
    public static int find(int num){
        if(parents[num] == num){
            return num;
        }
        parents[num] = find(parents[num]);
        return parents[num];
    }
}