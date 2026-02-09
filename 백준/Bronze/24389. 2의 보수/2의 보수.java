import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int reverseNum = num ^ ((1 << 31) - 1);
        reverseNum++;
        int answer = Integer.bitCount(num ^ reverseNum) + 1;
        bw.write(answer + "\n");
        bw.flush();
    }
}