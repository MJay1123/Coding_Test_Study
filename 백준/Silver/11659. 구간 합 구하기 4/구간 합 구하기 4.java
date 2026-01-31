

import java.io.*;
import java.util.StringTokenizer;

// 구간 합 구하기 4
public class Main {
    static int N;               // 수의 개수
    static int M;               // 합을 구해야 하는 횟수
    static int[] numbers;       // 누적합 배열
    static int temp;            // 누적 합 표시용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N+1];
        for(int i=1; i<=N; i++){
            temp += Integer.parseInt(st.nextToken());
            numbers[i] = temp;
        }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            bw.write(numbers[right] - numbers[left-1] + "\n");
        }
        bw.flush();
    }
}
