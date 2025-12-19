

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

// 집합
public class Main {
    static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int number = 0;
            if(!command.equals("all") && !command.equals("empty")){
                number = Integer.parseInt(st.nextToken());
            }

            switch(command) {
                case "add":
                    hs.add(number);
                    break;
                case "remove":
                    hs.remove(number);
                    break;
                case "check":
                    if (hs.contains(number)) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case "toggle":
                    if (hs.contains(number)) {
                        hs.remove(number);
                    } else {
                        hs.add(number);
                    }
                    break;
                case "all":
                    for (int num = 1; num <= 20; num++) {
                        hs.add(num);
                    }
                    break;
                case "empty":
                    hs.clear();
                    break;
            }
        }
        bw.flush();
    }
}
