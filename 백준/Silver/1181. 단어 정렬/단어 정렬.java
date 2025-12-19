import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> hs = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(hs.contains(word)){
                continue;
            }
            hs.add(word);
            pq.offer(word);
        }
        while(!pq.isEmpty()){
            bw.write(pq.poll() + "\n");
        }
        bw.flush();
    }
}
