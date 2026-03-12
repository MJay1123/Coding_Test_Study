import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N, W, H, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[W][H];
            int[] topNumArr = new int[W];
            for (int i = 0; i < W; i++) topNumArr[i] = -1;
            answer = Integer.MAX_VALUE;
            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    int val = Integer.parseInt(st.nextToken());
                    map[c][H - 1 - r] = val;
                    if (val != 0 && topNumArr[c] == -1) {
                        topNumArr[c] = H - 1 - r;
                    }
                }
            }

            dfs(0, map, topNumArr);
            sb.append("#").append(tc).append(" ").append(answer == Integer.MAX_VALUE ? 0 : answer).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int d, int[][] currentMap, int[] currentTop) {
        int count = 0;
        for (int i = 0; i < W; i++) {
            if (currentTop[i] != -1) {
                for (int j = 0; j <= currentTop[i]; j++) {
                    if (currentMap[i][j] != 0) count++;
                }
            }
        }

        if (count == 0) {
            answer = 0;
            return;
        }

        if (d == N) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < W; i++) {
            if (currentTop[i] == -1) continue;

            int[][] nextMap = copy(currentMap);
            int[] nextTop = currentTop.clone();

            bomb(i, nextTop[i], nextMap);
            gravity(nextMap, nextTop);
            
            dfs(d + 1, nextMap, nextTop);
            if (answer == 0) return;
        }
    }

    static void bomb(int x, int y, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, map[x][y]});
        map[x][y] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int p = curr[2];
            if (p <= 1) continue;

            for (int i = 0; i < 4; i++) {
                for (int s = 1; s < p; s++) {
                    int nx = curr[0] + dx[i] * s;
                    int ny = curr[1] + dy[i] * s;

                    if (nx >= 0 && nx < W && ny >= 0 && ny < H && map[nx][ny] != 0) {
                        q.add(new int[]{nx, ny, map[nx][ny]});
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }

    static void gravity(int[][] map, int[] top) {
        for (int i = 0; i < W; i++) {
            int[] nextRow = new int[H];
            int idx = 0;
            for (int j = 0; j < H; j++) {
                if (map[i][j] != 0) nextRow[idx++] = map[i][j];
            }
            map[i] = nextRow;
            top[i] = idx - 1;
        }
    }

    static int[][] copy(int[][] origin) {
        int[][] res = new int[W][H];
        for (int i = 0; i < W; i++) {
            System.arraycopy(origin[i], 0, res[i], 0, H);
        }
        return res;
    }
}
