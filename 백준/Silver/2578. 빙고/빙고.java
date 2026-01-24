import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[26][2];
        for(int r=0; r<5; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<5; c++){
                int number = Integer.parseInt(st.nextToken());
                arr[number][0] = r;
                arr[number][1] = c;
            }
        }
        int answer = 0;
        int count = 0;
        int[] rCount = new int[5];
        int[] cCount = new int[5];
        int[] dCount = new int[2];
        for(int r=0; r<5; r++){
            if(answer != 0){
                break;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<5; c++){
                int number = Integer.parseInt(st.nextToken());
                int R = arr[number][0];
                int C = arr[number][1];
                rCount[R]++;
                if(rCount[R] == 5){
                    count++;
                }
                cCount[C]++;
                if(cCount[C] == 5){
                    count++;
                }
                if(R == C){
                    dCount[0]++;
                    if(dCount[0] == 5){
                        count++;
                    }
                }
                if(R+C == 4){
                    dCount[1]++;
                    if(dCount[1] == 5){
                        count++;
                    }
                }
                if(count >= 3){
                    answer = r * 5 + c + 1;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
