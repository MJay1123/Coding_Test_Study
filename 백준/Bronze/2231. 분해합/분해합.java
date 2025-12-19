import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=1000000; i++){
            if(getNumber(i + "") == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    public static int getNumber(String number){
        int num = Integer.parseInt(number);
        String[] numberArray = number.split("");
        for(int i=0; i<numberArray.length; i++){
            num += Integer.parseInt(numberArray[i]);
        }
        return num;
    }
}