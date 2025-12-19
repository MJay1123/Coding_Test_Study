
// 저항
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();

        int num1 = colorToNum(color1, colors);
        int num2 = colorToNum(color2, colors);
        int num3 = colorToNum(color3, colors);

        long resistance = (num1 * 10 + num2) * (long)Math.pow(10, num3);
        bw.write(resistance + "\n");
        bw.flush();
    }

    public static int colorToNum(String color, String[] colors){
        for(int i=0; i<colors.length; i++){
            if(color.equals(colors[i])){
                return i;
            }
        }
        return -1;
    }
}
