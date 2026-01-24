import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 1;
        int increase = 1;
        int decrease = 1;
        int prev = arr[0];
        for(int i=1; i<N; i++) {
            if (prev < arr[i]) {
                increase++;
                decrease = 1;
            } else if (prev > arr[i]) {
                increase = 1;
                decrease++;
            } else {
                increase++;
                decrease++;
            }
            prev = arr[i];
            answer = Math.max(answer, increase);
            answer = Math.max(answer, decrease);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}

