import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numbers = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        String str = br.readLine();
        int answer = 0;
        for(int i=0; i<str.length(); i++) {
        	int index = str.charAt(i) - 'A';
        	answer += 2 + (numbers[index] - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
