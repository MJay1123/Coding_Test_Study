

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int maxLevel = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxLevel = Math.max(maxLevel, map[i][j]);
            }
        }
        int minTime = getBlockCount(map, 0) * 1 + getDigCount(map, 0) * 2;
        int minLevel = 0;
        // 땅 파기 : 시간 2 / 블럭 쌓기 : 시간 1
        for(int level = 1; level <= maxLevel; level++){
            int blockCount = getBlockCount(map, level);
            int digCount = getDigCount(map, level);
            if(B + digCount < blockCount){
                continue;
            }
            int time = getTime(digCount, blockCount);
            if(minTime >= time){
                minTime = time;
                minLevel = level;
            } else {
                break;
            }
        }
        System.out.println(minTime + " " + minLevel);
    }

    public static int getTime(int digCount, int blockCount){
        int time = digCount * 2 + blockCount;
        return time;
    }

    public static int getDigCount(int[][] map, int level){
        int count = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                int difference = map[i][j] - level;
                if(difference >= 0){
                    count += difference;
                }
            }
        }
        return count;
    }

    public static int getBlockCount(int[][] map, int level){
        int count = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                int difference = level - map[i][j];
                if(difference >= 0){
                    count += difference;
                }
            }
        }
        return count;
    }
}
