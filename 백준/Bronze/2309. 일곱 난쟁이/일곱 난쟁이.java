// 일곱 난쟁이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[9];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<9; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        changeList(list);

        for(int i=0; i<7; i++){
            System.out.println(list.get(i));
        }
    }

    public static void changeList(List<Integer> list){
        int sum = 0;
        for(int i=0; i<9; i++){
            sum += list.get(i);
        }

        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                int temp = list.get(i) + list.get(j);
                if(sum - temp == 100){
                    list.remove(j);
                    list.remove(i);
                    return;
                }
            }
        }
    }
}
