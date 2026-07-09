import java.util.*;
import java.io.*;

public class Solution {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        arr = new int[1001];
        for(int tc=1; tc<=TC; tc++){
            n = Integer.parseInt(br.readLine());
            int answer = get(n);
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int get(int n){
        if(arr[n] == 0){
            if(n == 0 || n == 1){
                arr[n] = 1;
            } else {
                int num = 1;
                while(true){
                    boolean flag = true;
                    for(int k=1; k<=(n/2); k++){
                        if(num + get(n - 2*k) == 2 * get(n - k)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        arr[n] = num;
                        break;
                    } else {
                        num++;
                        continue;
                    }
                }
        	}
        }
        return arr[n];
    }
}