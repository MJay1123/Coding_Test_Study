import java.io.*;

public class Main {
    static boolean isRight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        String regex = "(100+1+|01)+";
        for (int t = 0; t < T; t++) {
            String vega = br.readLine();
            isRight = vega.matches(regex);
            bw.write(isRight ? "YES\n" : "NO\n");
        }
        bw.flush();
    }
    // (100+1+|01)+
    // 1001
    // 01
}