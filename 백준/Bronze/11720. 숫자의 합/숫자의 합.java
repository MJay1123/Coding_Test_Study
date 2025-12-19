import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String str = br.readLine();
        for(int n=0; n<N; n++){
            answer += str.charAt(n) - '0';
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
