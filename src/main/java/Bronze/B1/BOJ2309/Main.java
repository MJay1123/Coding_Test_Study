package Bronze.B1.BOJ2309;
// 일곱 난쟁이
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[2][9];
        int sum = 0;
        for(int i=0; i<9; i++){
            arr[0][i] = Integer.parseInt(br.readLine());
            sum += arr[0][i];
        }
        sum -= 100;
        checkTwo(arr, sum);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<9; i++){
            if(arr[1][i] == 0){
                pq.offer(arr[0][i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void checkTwo(int[][] arr, int sum){
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(arr[0][i] + arr[0][j] == sum){
                    arr[1][i] = -1;
                    arr[1][j] = -1;
                    return;
                }
            }
        }
    }
}
