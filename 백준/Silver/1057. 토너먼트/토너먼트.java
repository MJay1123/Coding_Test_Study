

import java.io.*;
import java.util.StringTokenizer;

// 토너먼트
public class Main {

    static int N;           // 참가자의 수
    static int K;           // 김지민
    static int L;           // 임한수
    static int match;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        K -= 1;
        L -= 1;
        int count = 1;
        while(K / 2 != L / 2){
            K /= 2;
            L /= 2;
            count++;
        }
        System.out.println(count);
    }
}
