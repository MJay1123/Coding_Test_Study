import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int round=0; round<N; round++) {
            Sticker A = new Sticker();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int i = 0; i < a; i++) {
                A.add(Integer.parseInt(st.nextToken()));
            }
            Sticker B = new Sticker();
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int i = 0; i < b; i++) {
                B.add(Integer.parseInt(st.nextToken()));
            }
            if (A.equals(B)) {
                sb.append("D");
            } else {
                if (A.compareTo(B) < 0) {
                    sb.append("A");
                } else {
                    sb.append("B");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static class Sticker implements Comparable<Sticker>{
        int star;
        int circle;
        int square;
        int triangle;
        public Sticker() {

        }
        public void add(int i){
            switch(i){
                case 4:
                    star++;
                    break;
                case 3:
                    circle++;
                    break;
                case 2:
                    square++;
                    break;
                case 1:
                    triangle++;
                    break;
            }
        }
        @Override
        public boolean equals(Object o){
            if(o.getClass() != Sticker.class){
                return false;
            }
            Sticker s = (Sticker)o;
            if(this.star == s.star && this.circle == s.circle && this.square == s.square && this.triangle == s.triangle){
                return true;
            } else {
                return false;
            }
        }
        @Override
        public int compareTo(Sticker o) {
            if(this.star != o.star){
                return o.star - this.star;
            } else if(this.circle != o.circle){
                return o.circle - this.circle;
            } else if(this.square != o.square){
                return o.square - this.square;
            } else if(this.triangle != o.triangle){
                return o.triangle - this.triangle;
            } else {
                return 1;
            }
        }
    }
}
