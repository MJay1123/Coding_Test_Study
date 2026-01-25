import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int right = 0;
        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;
            right = Math.max(right, L+1);
        }
        int left = 0;
        for(int i=0; i<right; i++){
            if(arr[i] > 0){
                left = i;
                break;
            }
        }
        int width = right - left;
        int[][] heights = new int[2][width];
        heights[0][0] = arr[left];
        heights[1][width-1] = arr[right-1];
        for(int i=1; i<width; i++){
            heights[0][i] = heights[0][i-1] < arr[left+i] ? arr[left+i] : heights[0][i-1];
        }
        for(int i=width-2; i>=0; i--){
            heights[1][i] = arr[left+i] > heights[1][i+1] ? arr[left+i] : heights[1][i+1];
        }
        int answer = 0;
        for(int i=0; i<width; i++){
            answer += Math.min(heights[0][i], heights[1][i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}