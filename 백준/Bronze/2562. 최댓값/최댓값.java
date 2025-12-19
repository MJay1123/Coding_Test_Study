

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[9];
        int max = 0;
        int index = 0;
        for(int i=0; i<9; i++){
            numbers[i] = Integer.parseInt(br.readLine());
            if(numbers[i]>max){
                max = numbers[i];
                index = i+1;
            }
        }
        bw.write(max + "\n" + index);
        bw.flush();
    }
}
