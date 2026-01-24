package Silver.S1.BOJ2527;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] rectangle1 = new int[4];
            for (int i = 0; i < 4; i++) {
                rectangle1[i] = Integer.parseInt(st.nextToken());   // x, y, p, q
            }
            int[] rectangle2 = new int[4];
            for (int i = 0; i < 4; i++) {
                rectangle2[i] = Integer.parseInt(st.nextToken());
            }
            int horizontalCount = checkRange(rectangle1[0], rectangle1[2], rectangle2[0], rectangle2[2]);
            int verticalCount = checkRange(rectangle1[1], rectangle1[3], rectangle2[1], rectangle2[3]);
            if (horizontalCount == 0 || verticalCount == 0) {
                sb.append("d\n");
            } else if (horizontalCount > 1 && verticalCount > 1) {
                sb.append("a\n");
            } else if (horizontalCount == 1 && verticalCount == 1) {
                sb.append("c\n");
            } else {
                sb.append("b\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int checkRange(int a1, int a2, int b1, int b2){   // a1 < a2 , b1 < b2
        if(a2 < b1 || b2 < a1){
            return 0;
        }
        if(a2 == b1 || b2 == a1){
            return 1;
        }
        return 2;
    }
}