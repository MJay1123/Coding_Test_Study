import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                map[r][c] = str.charAt(c);
            }
        }
        boolean[][] visited = new boolean[R][C];
        boolean[] alphabet = new boolean[26];
        DFS(0,0,map,visited,alphabet,1);
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void DFS(int r, int c, char[][] map, boolean[][] visited, boolean[] alphabet, int depth){
        visited[r][c] = true;
        alphabet[map[r][c] - 'A'] = true;
        answer = Math.max(answer, depth);
        for(int i=0; i<4; i++){
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if(checkRange(nr, nc, map) && !visited[nr][nc] && !alphabet[map[nr][nc] - 'A']){
                DFS(nr, nc, map, visited, alphabet, depth+1);
            }
        }
        visited[r][c] = false;
        alphabet[map[r][c] - 'A'] = false;
        depth--;
    }

    public static boolean checkRange(int r, int c, char[][] map){
        return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
    }
}
