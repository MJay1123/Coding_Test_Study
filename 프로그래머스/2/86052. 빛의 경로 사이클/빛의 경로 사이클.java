import java.util.*;
class Solution {
    static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    class Light {
        int r;
        int c;
        int direction;
        public Light(int r, int c, int direction){
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }
    public int[] solution(String[] grid) {
        char[][] map = new char[grid.length][grid[0].length()];
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length(); c++){
                map[r][c] = grid[r].charAt(c);
            }
        }
        boolean[][][] visited = new boolean[map.length][map[0].length][4];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[0].length; c++){
                for(int d=0; d<4; d++){
                    if(!visited[r][c][d]){
                        pq.offer(DFS(new Light(r, c, d), map, visited));
                    }
                }
            }
        }
        int[] answer = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()){
            answer[index] = pq.poll();
            index++;
        }
        return answer;
    }
    public int DFS(Light light, char[][] map, boolean[][][] visited){
        int depth = 1;
        int r = light.r;
        int c = light.c;
        int direction = light.direction;
        visited[r][c][direction] = true;
        while(true){
            int nr = (r + directions[direction][0] + map.length) % map.length;
            int nc = (c + directions[direction][1] + map[0].length) % map[0].length;
            int nextDirection = 0;
            if(map[nr][nc] == 'S'){
                nextDirection = direction;
            } else if(map[nr][nc] == 'L'){
                nextDirection = (direction + 1) % 4;
            } else {
                nextDirection = (direction + 3) % 4;
            }
            if(!visited[nr][nc][nextDirection]){
                visited[nr][nc][nextDirection] = true;
                depth++;
                r = nr;
                c = nc;
                direction = nextDirection;
            } else {
                break;
            }
        }
        return depth;
    }
}