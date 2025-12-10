package Silver.S4.BOJ1244;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());        // 스위치 수
        int[] switches = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());        // 학생 수
        for(int student=0; student<M; student++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if(gender == 1){        // 남학생 : 1
                for(int i=1; i<=N; i++){
                    if(i % number == 0){
                        switches[i] = 1 - switches[i];
                    }
                }
            } else {                // 여학생 : 2
                switches[number] = 1 - switches[number];
                for(int i=1; number + i <= N && number - i >= 1; i++){
                    if(switches[number+i] == switches[number-i]){
                        switches[number+i] = 1 - switches[number+i];
                        switches[number-i] = 1 - switches[number-i];
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i=1; i<=N; i++) {
            bw.write(switches[i] + " ");
            if (i % 20 == 0) {
                bw.write("\n");
            }
        }
        bw.write("\n");
        bw.flush();
    }
}
