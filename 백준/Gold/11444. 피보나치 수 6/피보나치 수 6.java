import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    static HashMap<Long, Long> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        hm.put(0L, 0L);
        hm.put(1L, 1L);
        long answer = fibonacci(n);
        bw.write(answer + "\n");
        bw.flush();
    }

    public static long fibonacci(long num){
        if (hm.containsKey(num)) {
            return hm.get(num);
        }
        long result;
        if(num % 2 == 0){
            result = (fibonacci(num/2) * (2 * fibonacci(num/2 - 1) + fibonacci(num/2))) % 1000000007;
        } else {
            result = (fibonacci(num/2)*fibonacci(num/2) + fibonacci(num/2+1)*fibonacci(num/2+1)) % 1000000007;
        }
        hm.put(num, result);
        return result;
    }
}
