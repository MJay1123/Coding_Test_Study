
// 쉬운 최단거리
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int targetX = 0;
        int targetY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                }
            }
        }
        bfs(targetX, targetY);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    map[i][j] = -1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y){
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        visited[x][y] = true;
        map[x][y] = 0;

        while(!queue.isEmpty()){
            Location loc = queue.poll();
            for(int i=0; i<4; i++){
                int nx = loc.x + move[i][0];
                int ny = loc.y + move[i][1];
                if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = map[loc.x][loc.y] + 1;
                }
            }
        }


    }

    public static boolean checkRange(int x, int y){
         return (x >= 0 && x < n && y >= 0 && y < m);
    }
}
