import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] campus = new String[N][M];
        int startR = 0;
        int startC = 0;
        for(int i=0; i<N; i++){
            campus[i] = br.readLine().split("");
            for(int j=0; j<M; j++){
                if(campus[i][j].equals("I")){
                    startR = i;
                    startC = j;
                }
            }
        }
        boolean[][] visited = new boolean[N][M];
        BFS(startR, startC, campus, visited);
        if(answer == 0){
            bw.write("TT\n");
        } else {
            bw.write(answer + "\n");
        }
        bw.flush();
    }
    public static void BFS(int r, int c, String[][] campus, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new int[]{r,c});
        while(!queue.isEmpty()){
            int[] location = queue.poll();
            r = location[0];
            c = location[1];
            if(campus[r][c].equals("P")){
                answer++;
            }
            for(int i=0; i<4; i++){
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if(checkRange(nr, nc, campus) && !visited[nr][nc] && !campus[nr][nc].equals("X")){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
    public static boolean checkRange(int r, int c, String[][] campus){
        return r >= 0 && r < campus.length && c >= 0 && c < campus[0].length;
    }
}
