
// 어린 왕자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][3];
            int answer = 0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<n; i++){
                int x3 = arr[i][0];
                int y3 = arr[i][1];
                int r = arr[i][2];
                if(doubleCheck(x1, y1, x2, y2, x3, y3, r)){
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    public static boolean doubleCheck(int x1, int y1, int x2, int y2, int x3, int y3, int r){
        if(check(x1, y1, x3, y3, r) == true && check(x2, y2, x3, y3, r) == true){
            return false;
        } else if(check(x1, y1, x3, y3, r) == false && check(x2, y2, x3, y3, r) == false){
            return false;
        } else {
            return true;
        }
    }

    public static boolean check(int x1, int y1, int x, int y, int r){
        double distance = Math.sqrt(Math.pow(x-x1, 2) + Math.pow(y-y1, 2));
        if(distance < r){
            return true;
        } else {
            return false;
        }
    }
}
