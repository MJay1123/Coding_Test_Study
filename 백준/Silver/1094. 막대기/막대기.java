

import java.io.*;

// 막대기
public class Main {
    static int X;       // 필요한 막대의 길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        X = Integer.parseInt(br.readLine());
        bw.write(Integer.bitCount(X) + "\n");
        bw.flush();
    }
}
