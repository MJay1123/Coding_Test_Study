import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> hm = new HashMap<>();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String password = st.nextToken();
            hm.put(address, password);
        }
        for(int m=0; m<M; m++){
            String address = br.readLine();
            bw.write(hm.get(address));
            bw.write("\n");
        }
        bw.flush();
    }
}
