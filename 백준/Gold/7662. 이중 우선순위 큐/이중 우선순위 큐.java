import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                if (operation.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    if (!tm.containsKey(num)) {
                        tm.put(num, 0);
                    }
                    tm.put(num, tm.get(num) + 1);
                } else {
                    if(!tm.isEmpty()){
                        int a = Integer.parseInt(st.nextToken());
                        Map.Entry<Integer, Integer> entry;
                        if (a == 1) {
                            entry = tm.pollLastEntry();
                        } else {
                            entry = tm.pollFirstEntry();
                        }
                        int num = entry.getKey();
                        int count = entry.getValue();
                        count--;
                        if(count > 0) {
                            tm.put(num, count);
                        }
                    }
                }
            }
            if (tm.isEmpty()){
                bw.write("EMPTY\n");
            } else if(tm.size() == 1) {
                int num = tm.pollFirstEntry().getKey();
                bw.write(num + " " + num + "\n");
            } else {
                int max = tm.pollLastEntry().getKey();
                int min = tm.pollFirstEntry().getKey();
                bw.write(max + " " + min + "\n");
            }
        }
        bw.flush();
    }
}
