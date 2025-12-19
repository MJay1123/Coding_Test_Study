import java.io.*;
import java.util.StringTokenizer;

// 게임
public class Main {
    static double X;       // 게임 횟수
    static double Y;       // 이긴 게임
    static int Z;       // 승률(소수점은 버린다.)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        X = Double.parseDouble(st.nextToken());
        Y = Double.parseDouble(st.nextToken());
        Z = (int)(Y * 100 / X);

        double answer = (X*Z + X - 100*Y) / (99 - Z);

        if(answer <= 0 || Z == 99){
            bw.write(-1 + "\n");
        } else {
            bw.write((int) Math.ceil(answer) + "\n");
        }
        bw.flush();
    }
}
