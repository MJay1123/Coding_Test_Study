import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Member implements Comparable<Member>{
        int age;
        String name;
        int number;
        public Member(int age, String name, int number){
            this.age = age;
            this.name = name;
            this.number = number;
        }
        @Override
        public int compareTo(Member o){
            if(this.age == o.age){
                return this.number - o.number;
            } else {
                return this.age - o.age;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int number = 1;
        PriorityQueue<Member> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.offer(new Member(age, name, number));
            number++;
        }
        while(!pq.isEmpty()){
            Member member = pq.poll();
            bw.write(member.age + " " + member.name + "\n");
        }
        bw.flush();
    }
}
