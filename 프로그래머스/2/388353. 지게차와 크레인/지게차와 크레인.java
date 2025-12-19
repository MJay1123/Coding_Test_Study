import java.util.*;
class Solution {
    static int move[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public int solution(String[] storage, String[] requests) {
        String[][] map = new String[storage.length+2][storage[0].length()+2];
        for(int r=1; r<map.length-1; r++){
            String str = storage[r-1];
            for(int c=1; c<map[0].length-1; c++){
                map[r][c] = str.charAt(c-1) + "";
            }
        }
        // 문제 풀이
        for(String request : requests){
            if(request.length() == 1){      // bfs
                boolean[][] visited = new boolean[map.length][map[0].length];
                bfs(new Location(0,0), request, map, visited);
            } else {                        // pickAll
                pickAll(request.substring(0,1), map);
            }
        }
        int answer = 0;
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[0].length; c++){
                if(map[r][c] != null){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public void pickAll(String target, String[][] map){           // 크레인으로 모든 컨테이너 회수
        for(int r=1; r<map.length-1; r++){
            for(int c=1; c<map[0].length-1; c++){
                if(map[r][c] != null && map[r][c].equals(target)){
                    map[r][c] = null;
                }
            }
        }
    }

    public void bfs(Location loc, String target, String[][] map, boolean[][] visited){
        Queue<Location> queue = new LinkedList<>();
        int r = loc.r;
        int c = loc.c;
        queue.offer(loc);
        visited[r][c] = true;
        while(!queue.isEmpty()){
            loc = queue.poll();
            r = loc.r;
            c = loc.c;
            for(int i=0; i<4; i++){
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if(checkRange(nr, nc, map) && !visited[nr][nc]){
                    if(map[nr][nc] == null){                    // null이면 bfs 계속 진행
                        queue.offer(new Location(nr, nc));
                        visited[nr][nc] = true;
                    } else if(map[nr][nc].equals(target)){      // target이면 컨테이너 회수 후에 더 못 들어감
                        map[nr][nc] = null;
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
    
    public boolean checkRange(int r, int c, String[][] map){
        return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
    }
    
    static class Location {
        int r;
        int c;
        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}