import java.util.*;
class Solution {
    static int around[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static char[][] map;
    static int answer;
    static int R, C;
    static char empty = 'a' - 'a';
    public int solution(String[] storage, String[] requests) {
        R = storage.length + 2;
        C = storage[0].length() + 2;
        map = new char[R][C];
        for(int r=0; r<storage.length; r++){
            String str = storage[r];
            for(int c=0; c<str.length(); c++){
                map[r+1][c+1] = str.charAt(c);
            }
        }
        answer = (R-2) * (C-2);
        for(int i=0; i<requests.length; i++){
            if(requests[i].length() == 1){
                jigaechar(requests[i].charAt(0));
            } else {
                crane(requests[i].charAt(0));
            }
        }
        return answer;
    }
    public static boolean checkRange(int r, int c){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
    
    public static void jigaechar(char container){
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        rQueue.offer(0);
        cQueue.offer(0);
        visited[0][0] = true;
        while(!rQueue.isEmpty()){
            int r = rQueue.poll();
            int c = cQueue.poll();
            for(int i=0; i<4; i++){
                int nr = r + around[i][0];
                int nc = c + around[i][1];
                if(checkRange(nr, nc) && !visited[nr][nc]){
                    if(map[nr][nc] == empty){
                        rQueue.offer(nr);
                        cQueue.offer(nc);
                        visited[nr][nc] = true;
                    } else if(map[nr][nc] == container){
                        map[nr][nc] = empty;
                        answer--;
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
    public static void crane(char container){
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[0].length; c++){
                if(map[r][c] == container){
                    map[r][c] = empty;
                    answer--;
                }
            }
        }
    }
}