import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            Person[] people = new Person[N+1];
            for(int i=1; i<=N; i++){
                people[i] = new Person(i);
            }
            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int child = Integer.parseInt(st.nextToken());
                int parent = Integer.parseInt(st.nextToken());
                people[child].parents.add(parent);
                people[parent].children.add(child);
            }
            int answer = 0;
            for(int i=1; i<=N; i++){
                boolean[] visited = new boolean[N+1];
            	int parentCount = pDFS(i, people, visited);
                visited = new boolean[N+1];
                int childCount = cDFS(i, people, visited);
                if(parentCount - 1 + childCount - 1 == N-1){
                    answer++;
                }
            }
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
    public static int pDFS(int num, Person[] people, boolean[] visited){
        visited[num] = true;
        int count = 1;
        for(int next : people[num].parents){
            if(!visited[next]){
                count += pDFS(next, people, visited);
            }
        }
        return count;
    }
    public static int cDFS(int num, Person[] people, boolean[] visited){
        visited[num] = true;
        int count = 1;
        for(int next : people[num].children){
            if(!visited[next]){
                count += cDFS(next, people, visited);
            }
        }
        return count;
    }
    static class Person {
        int number;
        List<Integer> parents;
        List<Integer> children;
        
        public Person(int number) {
            this.number = number;
            this.parents = new ArrayList<>();
            this.children = new ArrayList<>();
        }
    }
}