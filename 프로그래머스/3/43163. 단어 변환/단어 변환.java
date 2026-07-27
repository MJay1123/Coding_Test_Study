import java.util.*;
class Solution {
    static boolean[][] graph;
    static int targetIndex = -1;
    public int solution(String begin, String target, String[] words) {
        graph = new boolean[words.length+1][words.length+1];
        for(int i=0; i<words.length; i++){
            if(similar(words[i], begin)){
                graph[0][i+1] = true;
                graph[i+1][0] = true;
            }
        }
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words.length; j++){
                if(similar(words[i], words[j])){
                    graph[i+1][j+1] = true;
                    graph[j+1][i+1] = true;
                }
            }
        }
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                targetIndex = i+1;
            }
        }
        return BFS(0, targetIndex);
    }
    public static int BFS(int start, int targetIndex){
        if(targetIndex == -1){
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> distQueue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.offer(start);
        distQueue.offer(0);
        visited[start] = true;
        while(!queue.isEmpty()){
            int num = queue.poll();
            int dist = distQueue.poll();
            if(num == targetIndex){
                return dist;
            }
            for(int i=0; i<graph.length; i++){
                if(!visited[i] && graph[num][i]){
                    queue.offer(i);
                    distQueue.offer(dist+1);
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    public boolean similar(String word1, String word2){
        int count = 0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        } else {
            return false;
        }
    }
}