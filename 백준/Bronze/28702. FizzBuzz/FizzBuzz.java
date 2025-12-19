import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int index = 0;
        for(int i=0; i<3; i++){
            String str = br.readLine();
            if(str.matches("[0-9]*")) {
                index = Integer.parseInt(str);
            } else {
                index++;
            }
        }
        index++;
        if(index % 15 == 0){
            bw.write("FizzBuzz\n");
        } else if(index % 3 == 0){
            bw.write("Fizz\n");
        } else if(index % 5 == 0){
            bw.write("Buzz\n");
        } else {
            bw.write(index + "\n");
        }
        bw.flush();
    }
}
