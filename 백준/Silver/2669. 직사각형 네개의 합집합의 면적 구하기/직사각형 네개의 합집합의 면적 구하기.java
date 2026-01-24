import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] rectangles =  new int[4][4];    // {x1, y1, x2, y2}
        int maxX = 0;
        int maxY = 0;
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                rectangles[i][j] = Integer.parseInt(st.nextToken());
            }
            maxX = Math.max(maxX, rectangles[i][2]);
            maxY = Math.max(maxY, rectangles[i][3]);
        }
        int[][] map = new int[maxY][maxX];
        int answer = 0;
        for(int rec=0; rec<4; rec++){
            int[] rectangle = rectangles[rec];
            for(int r=rectangle[1]; r<rectangle[3]; r++){
                for(int c=rectangle[0]; c<rectangle[2]; c++){
                    if(map[r][c] == 0){
                        answer++;
                    }
                    map[r][c]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}