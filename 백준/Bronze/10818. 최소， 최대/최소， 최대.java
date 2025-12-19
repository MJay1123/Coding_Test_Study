

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int min = 1000000;
        int max = -1000000;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }
        bw.write(min + " " + max);
        bw.flush();
    }
}
