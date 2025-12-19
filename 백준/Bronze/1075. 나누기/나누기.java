// 나누기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = N /= 100;
        N = N * 100;
        while(N % F != 0){
            N++;
        }
        String number = N + "";
        number = number.substring(number.length()-2, number.length());
        System.out.println(number);
    }
}
