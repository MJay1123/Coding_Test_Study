

import java.io.*;
import java.util.*;

// 듣보잡
public class Main {
    static int N;               // 듣도 못한 사람의 수
    static int M;               // 보도 못한 사람의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> notListened = new HashSet<>();
        for(int i=0; i<N; i++){
            String name = br.readLine();
            notListened.add(name);
        }
        List<String> notBoth = new ArrayList<>();
        for(int i=0; i<M; i++){
            String name = br.readLine();
            if(notListened.contains(name)){
                notBoth.add(name);
            }
        }
        Collections.sort(notBoth);
        bw.write(notBoth.size() + "\n");
        for(int i=0; i<notBoth.size(); i++){
            bw.write(notBoth.get(i) + "\n");
        }
        bw.flush();
    }
}
