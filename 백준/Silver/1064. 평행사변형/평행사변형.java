

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 평행사변형
public class Main {
    static int xa, xb, ya, yb, xc, yc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        xa = Integer.parseInt(st.nextToken());
        ya = Integer.parseInt(st.nextToken());
        xb = Integer.parseInt(st.nextToken());
        yb = Integer.parseInt(st.nextToken());
        xc = Integer.parseInt(st.nextToken());
        yc = Integer.parseInt(st.nextToken());

        if((yb-ya)*(xc-xb) == (yc-yb)*(xb-xa)){       // 세 점이 한 직선 위에 있으면 -1
            bw.write(-1.0 + "\n");
        } else {

            double line1 = Math.sqrt(Math.pow(xb - xa, 2) + Math.pow(yb - ya, 2));
            double line2 = Math.sqrt(Math.pow(xc - xa, 2) + Math.pow(yc - ya, 2));
            double line3 = Math.sqrt(Math.pow(xc - xb, 2) + Math.pow(yc - yb, 2));

            double sum1 = line1 + line2;
            double sum2 = line1 + line3;
            double sum3 = line2 + line3;
            List<Double> list = new ArrayList<Double>();
            list.add(sum1 * 2);
            list.add(sum2 * 2);
            list.add(sum3 * 2);
            Collections.sort(list);
            bw.write(list.get(2) - list.get(0) + "\n");
        }
        bw.flush();
    }
}
