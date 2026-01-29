import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[] arr = new int[257];
        int[] heightRange = new int[2];
        heightRange[0] = 256;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                arr[map[i][j]]++;
                heightRange[1] = Math.max(heightRange[1], map[i][j]);
                heightRange[0] = Math.min(heightRange[0], map[i][j]);
            }
        }
        // 땅 파기 : 시간 2 / 블럭 쌓기 : 시간 1
        int[] result = getTime(arr, heightRange);
        bw.write(result[0] + " " + result[1] + "\n");
        bw.flush();
    }

    public static int[] getTime(int[] arr, int[] heightRange){
        int minTime = Integer.MAX_VALUE;
        int minH = heightRange[0];
        int maxH = heightRange[1];
        int[] result = new int[2];      // {time, height}
        for(int height=heightRange[0]; height<=heightRange[1]; height++){
            int needBlock = 0;
            int time = 0;
            for(int i=minH; i<=maxH; i++){
                if(height > i){
                    time += (height-i)*arr[i];
                } else {
                    time += 2*(i-height)*arr[i];
                }
                needBlock += (height-i)*arr[i];
            }
            if(needBlock > B){
                continue;
            }
            if(minTime >= time){
                minTime = time;
                result[0] = minTime;
                result[1] = height;
            }
        }
        return result;
    }
}
