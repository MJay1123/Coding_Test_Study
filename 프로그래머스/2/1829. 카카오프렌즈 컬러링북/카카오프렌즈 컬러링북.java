import java.util.*;
class Solution {
    public static int[][] around = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] visited;
    static int M, N;
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        M = m;
        N = n;
        int maxArea = 0;
        int areaCount = 0;
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(!visited[r][c] && picture[r][c] != 0){
                    int area = BFS(r, c, picture);
                    maxArea = Math.max(maxArea, area);
                    areaCount++;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = areaCount;
        answer[1] = maxArea;
        return answer;
    }
    public static boolean checkRange(int r, int c){
        return r >= 0 && r < M && c >= 0 && c < N;
    }
    public static int BFS(int startR, int startC, int[][] picture){
        int count = 0;
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        rQueue.offer(startR);
        cQueue.offer(startC);
        count++;
        visited[startR][startC] = true;
        while(!rQueue.isEmpty()){
            int r = rQueue.poll();
            int c = cQueue.poll();
            for(int i=0; i<4; i++){
                int nr = r + around[i][0];
                int nc = c + around[i][1];
                if(checkRange(nr, nc) && !visited[nr][nc] && picture[nr][nc] == picture[startR][startC]){
                    rQueue.offer(nr);
                    cQueue.offer(nc);
                    visited[nr][nc] = true;
                    count++;
                }
            }
        }
        return count;
    }
    
}