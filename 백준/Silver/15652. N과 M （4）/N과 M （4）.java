import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] result;
    static List<int[]> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }
        result = new int[M];
        choose(arr, 0, 0, M);
        bw.write(sb.toString());
        bw.flush();
    }

    public static void choose(int[] arr, int start, int depth, int count){
        if(depth == count){
            for(int i=0; i<result.length; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<arr.length; i++){
            result[depth] = arr[i];
            choose(arr, i, depth+1, count);
        }
    }
}
