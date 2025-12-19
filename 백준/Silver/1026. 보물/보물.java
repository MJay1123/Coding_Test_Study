

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] array1 = new int[N];
        int[] array2 = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            array1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            array2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        int sum = 0;
        for(int i=0; i<N; i++){
            sum += array1[i]*array2[N-1-i];
        }
        bw.write(sum + "\n");
        bw.flush();
    }
}
