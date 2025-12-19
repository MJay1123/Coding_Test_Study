import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        long sum = 0;
        for(int i=0; i<N; i++){
            sum += arr[i];
            if(sum >= S){
                right = i;
                break;
            }
        }
        if(sum < S){
            bw.write(0 + "\n");
        } else {
            answer[0] = left;
            answer[1] = right;
            while(true){
                if(sum >= S){
                    if(right - left < answer[1] - answer[0]){
                        answer[0] = left;
                        answer[1] = right;
                    }
                    if(left == right){
                        break;
                    } else {
                        sum -= arr[left];
                        left++;
                    }
                } else {
                    right++;
                    if(right == N){
                        break;
                    }
                    sum += arr[right];
                }
            }
            bw.write(answer[1] - answer[0] + 1 + "\n");
        }
        bw.flush();
    }
}
