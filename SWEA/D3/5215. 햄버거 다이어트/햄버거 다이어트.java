import java.util.*;
import java.io.*;
public class Solution {
    static int N, L;
    static int[][] ingredients;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            ingredients = new int[N][2];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            choose(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void choose(int index, int score, int calorie){
        if(calorie > L){
            return;
        }
        if(index == N){
            answer = Math.max(answer, score);
            return;
        }
        choose(index+1, score+ingredients[index][0], calorie+ingredients[index][1]);	// 재료 선택 O
        choose(index+1, score, calorie);	// 재료 선택 X
    }
}