import java.io.*;
import java.util.*;

public class Main {
    static int[] pair = {5, 3, 4, 1, 2, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] dices = new int[N][6];
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<6; i++){
                dices[n][i] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int startIndex=0; startIndex<6; startIndex++){
            boolean[][] visited = stackDices(startIndex, dices);
            int result = 0;
            for(int r=0; r<N; r++){
                int temp = 0;
                for(int c=0; c<6; c++){
                    if(!visited[r][c]){
                        temp = Math.max(temp, dices[r][c]);
                    }
                }
                result += temp;
            }
            answer = Math.max(answer, result);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
    public static boolean[][] stackDices(int startIndex, int[][] dices){
        boolean[][] visited = new boolean[dices.length][6];
        int height = 0;
        int index = startIndex;
        visited[height][index] = true;
        visited[height][pair[index]] = true;
        int nextNumber = dices[height][pair[index]];
        height++;
        while(true){
            if(height >= dices.length){
                break;
            }
            for(int i=0; i<6; i++){
                if(dices[height][i] == nextNumber){
                    index = i;
                    break;
                }
            }
            visited[height][index] = true;
            visited[height][pair[index]] = true;
            nextNumber = dices[height][pair[index]];
            height++;
        }
        return visited;
    }
}
