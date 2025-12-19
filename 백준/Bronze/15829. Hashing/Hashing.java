import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        long r = 1L;
        for(int i=0; i<L; i++){
            int num = str.charAt(i) - 'a' + 1;
            answer += num * r;
            answer %= 1234567891;
            r = (r * 31) % 1234567891;
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
