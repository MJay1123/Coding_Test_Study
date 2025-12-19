

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;               // 자연수
    static int M;               // M개 고르기
    static int[] numbers;       // 숫자
    static boolean[] visited;   // 고른 숫자
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = i+1;
        }
        visited = new boolean[N];
        combination(0,0);
        bw.flush();
    }

    public static void combination(int index, int depth) throws IOException {
        if(depth == M){
            for(int i=0; i<N; i++){
                if(visited[i]){
                    bw.write(numbers[i] + " ");
                }
            }
            bw.write("\n");
            return;
        }
        if(index == N){
            return;
        }
        visited[index] = true;
        combination(index+1, depth+1);

        visited[index] = false;
        combination(index+1, depth);
    }
}
