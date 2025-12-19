
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int T;                           // 테스트 케이스 개수
    static int[] fibonacciZero;             // 0이 나오는 횟수의 배열
    static int[] fibonacciOne;              // 1이 나오는 횟수의 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        int max = 0;
        List<Integer> numbers = new ArrayList<>();              // 케이스 숫자들을 담는 배열
        for(int i=0; i<T; i++){
            int number = Integer.parseInt(br.readLine());
            numbers.add(number);
            max = Math.max(max, number);                        // 최대 숫자 확인(피보나치 함수 횟수 줄이기 위해서)
        }
        fibonacciZero = new int[max+1];                         // 0이 사용된 횟수 배열(피보나치)
        fibonacciOne = new int[max+1];                          // 1이 사용된 횟수 배열(피보나치)

        for(int i=0; i<=max; i++){
            if(i == 0) {
                fibonacciZero[i] = 1;
                fibonacciOne[i] = 0;
            } else if(i == 1){
                fibonacciZero[i] = 0;
                fibonacciOne[i] = 1;
            } else {
                fibonacciZero[i] = fibonacciZero[i - 1] + fibonacciZero[i - 2];
                fibonacciOne[i] = fibonacciOne[i - 1] + fibonacciOne[i - 2];
            }
        }

        for(int i : numbers){
            bw.write(fibonacciZero[i] + " " + fibonacciOne[i] + "\n");
        }
        bw.flush();
    }
}
