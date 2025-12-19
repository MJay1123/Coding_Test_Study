import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> numbers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<=9; i++) {
            List<Integer> list = new ArrayList<>();
            DFS(list, i);
        }
        Collections.sort(numbers);
        if(N >= numbers.size()){
            bw.write(-1 + "\n");
        } else {
            bw.write(numbers.get(N) + "\n");
        }
        bw.flush();
    }
    public static void DFS(List<Integer> list, int num){
        if(!list.isEmpty() && list.get(list.size()-1) <= num) {
            return;
        }
        list.add(num);
        long number = 0;
        for(int i=list.size()-1; i>=0; i--){
            number += list.get(i) * Math.pow(10, list.size()-1-i);
        }
        numbers.add(number);
        for(int i=0; i<=9; i++){
            DFS(list, i);
        }
        if(!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
    }
}
