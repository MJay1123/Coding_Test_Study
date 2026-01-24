import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 참외밭
public class Main {
    static int fruit;           // 단위 면적 당 자라는 참외의 개수
    static int[] sides = new int[6];
    static int maxIndex1, maxIndex2, minIndex1, minIndex2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1 : 동쪽 / 2 : 서쪽 / 3 : 남쪽 / 4 : 북쪽
        fruit = Integer.parseInt(br.readLine());
        for(int i=0; i<6; i++){
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            sides[i] = length;
        }
        int maxLength1 = 0;
        int maxLength2 = 0;
        maxIndex1 = 0;
        maxIndex2 = 1;
        for(int i=0; i<6; i+=2){
            if(sides[i] > maxLength1){
                maxLength1 = sides[i];
                maxIndex1 = i;
            }
        }
        for(int i=1; i<6; i+=2) {
            if (sides[i] > maxLength2) {
                maxLength2 = sides[i];
                maxIndex2 = i;
            }
        }
        if(maxIndex1 == 0 && maxIndex2 == 5){
            minIndex1 = 2;
            minIndex2 = 3;
        } else {
            if (maxIndex1 < maxIndex2) {
                minIndex1 = maxIndex1 - 2;
                minIndex2 = maxIndex2 + 2;
            } else {
                minIndex1 = maxIndex1 + 2;
                minIndex2 = maxIndex2 - 2;
            }
            minIndex1 = changeIndex(minIndex1);
            minIndex2 = changeIndex(minIndex2);
        }

        int area = sides[maxIndex1] * sides[maxIndex2] - sides[minIndex1] * sides[minIndex2];
        bw.write(fruit * area + "\n");
        bw.flush();
    }

    public static int changeIndex(int num){
        if(num >= 6){
            num -= 6;
        } else if(num < 0){
            num += 6;
        }
        return num;
    }
}
