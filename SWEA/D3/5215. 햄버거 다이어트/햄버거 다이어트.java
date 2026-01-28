import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[][] ingredients = new int[N][2];
            List<Ingredient> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int calorie = Integer.parseInt(st.nextToken());
                list.add(new Ingredient(score, calorie));
            }
            Collections.sort(list);
            
            int answer = choose(list, 0, 0, 0, L);
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
	}
    public static int choose(List<Ingredient> list, int score, int calorie, int index, int L){
        if(calorie > L){
            return -1;
        }
        if(index == list.size()){
            return score;
        }
        Ingredient i = list.get(index);
        return Math.max(choose(list, score+i.score, calorie+i.calorie, index+1, L), choose(list, score, calorie, index+1, L));
    }
    static class Ingredient implements Comparable<Ingredient>{
        int score;
        int calorie;
        public Ingredient(int score, int calorie){
            this.score = score;
            this.calorie = calorie;
        }
        
        @Override
        public int compareTo(Ingredient i){
            if(this.calorie != i.calorie){
                return this.calorie - i.calorie;
            }
            return i.score - this.score;
        }
        @Override
        public String toString(){
            return "score : " + score + ", calorie : " + calorie;
        }
    }
}