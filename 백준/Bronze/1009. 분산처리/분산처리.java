

import java.io.*;
import java.util.StringTokenizer;

// 분산처리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());      // T : 테스트 케이스의 개수
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 1;
            while(b > 0){
                result = (result * a) % 10;
                b--;
            }
            if(result == 0){
                result = 10;
            }
            bw.write(result + "\n");
            bw.flush();
        }
    }
}
