import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        for(char ch='a'; ch<='z'; ch++){
            String str = ch + "";
            bw.write(string.indexOf(str) + " ");
        }
        bw.flush();
    }
}
