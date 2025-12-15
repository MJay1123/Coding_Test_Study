
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int[][] arr = new int[t][6];

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<t; i++){
            System.out.println(calculate(arr[i]));
        }
    }

    public static int calculate(int[] arr){
        int rMax = Math.max(arr[2], arr[5]);
        int rMin = Math.min(arr[2], arr[5]);
        double distance = getDistance(arr[0], arr[1], arr[3], arr[4]);

        if(rMax == rMin && distance == 0){
            return -1;
        }

        if(rMax > distance){
            if(rMax - rMin < distance){
                return 2;
            } else if(rMax - rMin == distance){
                return 1;
            } else {
                return 0;
            }
        } else if(rMax < distance){
            if(rMax + rMin > distance){
                return 2;
            } else if(rMax + rMin == distance){
                return 1;
            } else {
                return 0;
            }
        } else {
            return 2;
        }
    }

    public static double getDistance(int x1, int y1, int x2, int y2){
        double distance = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
        return distance;
    }
}
