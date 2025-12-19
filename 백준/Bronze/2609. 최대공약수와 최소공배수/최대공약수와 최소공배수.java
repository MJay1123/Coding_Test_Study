

import java.io.*;
import java.util.StringTokenizer;

// 최대공약수와 최대공배수
public class Main {
    static int a;
    static int b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        // ----------------------------------------------------------------------)
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int temp = 0;
        while(min != 0){
            max = max % min;
            temp = max;
            max = min;
            min = temp;
        }
        if(min == 0){
            bw.write(max + "\n");
            bw.write(a * b / max +  "\n");
        }
        bw.flush();
    }
}
