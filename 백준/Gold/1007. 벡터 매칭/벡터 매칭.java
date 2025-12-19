import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static double answer;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            answer = Double.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            boolean[] choose = new boolean[N];
            combination(choose, 0, 0);
            bw.write(answer + "\n");
        }
        bw.flush();
    }
    public static void combination(boolean[] choose, int depth, int index){
        if(depth == choose.length / 2){
            long x = 0;
            long y = 0;
            for(int i=0; i<choose.length; i++){
                if(choose[i]){
                    x += arr[i][0];
                    y += arr[i][1];
                } else {
                    x -= arr[i][0];
                    y -= arr[i][1];
                }
            }
            long k = x*x + y*y;
            answer = Math.min(answer, Math.sqrt(k));
            return;
        }
        if(index >= choose.length){
            return;
        }
        choose[index] = true;
        combination(choose, depth+1, index+1);
        choose[index] = false;
        combination(choose, depth, index+1);
    }
}
