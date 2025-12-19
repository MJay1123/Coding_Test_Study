import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int num = A * B * C;
        int[] count = new int[10];
        while(num > 0){
            int digit = num % 10;
            count[digit]++;
            num /= 10;
        }
        for(int i=0; i<10; i++){
            bw.write(count[i] + "\n");
        }
        bw.flush();
    }
}
