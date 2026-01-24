import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int maxSecond = -1;
        int maxCount = 0;
        for(int second=0; second<=N; second++){
            int current = N;
            int next = second;
            int count = 2;
            while(true){
                if (current - next < 0) {
                    break;
                }
                int temp = current - next;
                current = next;
                next = temp;
                count++;
            }
            if(maxCount < count){
                maxCount = count;
                maxSecond = second;
            }
        }
        int current = N;
        int next = maxSecond;
        StringBuilder sb = new StringBuilder();
        sb.append(maxCount).append("\n");
        sb.append(current).append(" ");
        while(true){
            sb.append(next).append(" ");
            if(current - next < 0){
                break;
            }
            int temp = current - next;
            current = next;
            next = temp;
        }
        bw.write(sb.toString());
        bw.flush();
    }
}