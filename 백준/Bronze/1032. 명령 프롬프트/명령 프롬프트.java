
// 명령 프롬포트
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        int length = arr[0].length();
        String answer = "";
        for(int i=0; i<length; i++){
            HashSet<Character> hs = new HashSet<>();
            for(int j=0; j<arr.length; j++){
                hs.add(arr[j].charAt(i));
            }
            if(hs.size() == 1){
                for(char ch : hs){
                    answer += ch;
                }
            } else {
                answer += "?";
            }
        }
        System.out.println(answer);
    }
}
