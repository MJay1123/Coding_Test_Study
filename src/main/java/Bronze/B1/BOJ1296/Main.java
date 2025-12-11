package Bronze.B1.BOJ1296;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int L;
    static int O;
    static int V;
    static int E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String name = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] teamNames = new String[N];
        int[] percentage = new int[N];
        for(int i=0; i<N; i++){
            teamNames[i] = br.readLine();
        }
        int max = 0;
        for(int i=0; i<N; i++){
            L = 0;
            O = 0;
            V = 0;
            E = 0;
            add(name);
            String teamName = teamNames[i];
            add(teamName);
            percentage[i] = calculate();
            max = Math.max(max, percentage[i]);
        }
        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            if(percentage[i] == max){
                list.add(teamNames[i]);
            }
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
    }
    public static int calculate(){
        int result = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
        return result;
    }
    public static void add(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'L'){
                L++;
            }
            if(str.charAt(i) == 'O'){
                O++;
            }
            if(str.charAt(i) == 'V'){
                V++;
            }
            if(str.charAt(i) == 'E'){
                E++;
            }
        }
    }
}
