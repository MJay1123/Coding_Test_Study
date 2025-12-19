import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int testCase=0; testCase<T; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int floor = (N-1) % H + 1;
            int room = (N-1) / H + 1;
            if(room < 10){
                bw.write(floor + "0" + room + "\n");
            } else {
                bw.write(floor + "" + room + "\n");
            }
        }
        bw.flush();
    }
}
