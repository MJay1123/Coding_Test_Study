import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] connection = new int[N+1][N+1];
        for(int i=0; i<road.length; i++){
            int num1 = road[i][0];
            int num2 = road[i][1];
            int distance = road[i][2];
            if(connection[num1][num2] == 0 || connection[num1][num2] > distance){
                connection[num1][num2] = distance;
            }
            if(connection[num2][num1] == 0 || connection[num2][num1] > distance){
                connection[num2][num1] = distance;
            }
        }
        int[] distances = new int[N+1];
        Queue<Integer> numQueue = new LinkedList<>();
        Queue<Integer> distQueue = new LinkedList<>();
        numQueue.offer(1);
        distQueue.offer(0);
        while(!numQueue.isEmpty()){
            int cn = numQueue.poll();
            int cd = distQueue.poll();
            for(int nn=2; nn<=N; nn++){
                if(cn == nn){
                    continue;
                }
                if(connection[cn][nn] == 0){
                    continue;
                }
                int nd = cd + connection[cn][nn];
                if(distances[nn] == 0 || nd < distances[nn]){
                    distances[nn] = nd;
                    numQueue.offer(nn);
                    distQueue.offer(nd);
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(distances[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}