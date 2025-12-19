
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좋은 구간
public class Main {
    static int L;               // 집합의 크기
    static int[] numbers;       // 숫자들의 집합
    static int n;               // 포함해야 하는 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        L = Integer.parseInt(br.readLine());
        numbers = new int[L];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<L; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        n = Integer.parseInt(br.readLine());

        // 문제 풀이
        Arrays.sort(numbers);
        int range = -1;
        int answer = -1;
        for(int i=0; i<L; i++){
            if(numbers[i] == n) {
                answer = 0;
                break;
            } else if(numbers[i] > n){
                range = i-1;
                break;
            }
        }
        if(answer == 0){            // 가능성 없음
            bw.write(answer + "\n");
        } else {                    // range와 range+1 사이에서 계산 수행
            int min = 1;
            int max = numbers[range+1]-1;
            if(range != -1) {
                min = numbers[range]+1;
            }
            answer = ((n-1)-min+1)*(max-n+1) + (max-(n+1)+1);
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
