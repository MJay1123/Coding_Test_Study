import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fruits = new int[N];
        for(int i=0; i<N; i++){
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(true){
            if(hm.keySet().size() <= 2){
                answer = Math.max(answer, right - left);
                right++;
                if(right > fruits.length){
                    break;
                }
                addFruit(fruits[right-1], hm);
            } else {
                left++;
                removeFruit(fruits[left-1], hm);
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
    public static void addFruit(int fruit, HashMap<Integer, Integer> hm){
        if(hm.containsKey(fruit)) {
            hm.replace(fruit, hm.get(fruit) + 1);
        } else {
            hm.put(fruit, 1);
        }
    }
    public static void removeFruit(int fruit, HashMap<Integer, Integer> hm){
        hm.replace(fruit, hm.get(fruit) - 1);
        if(hm.get(fruit) == 0){
            hm.remove(fruit);
        }
    }
}
