import java.util.*;
class Solution {
    static int[] parents;
    static int count;
    static int answer;
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        List<Bridge> bridges = new ArrayList<>();
        for(int i=0; i<costs.length; i++){
            bridges.add(new Bridge(costs[i]));
        }
        Collections.sort(bridges);
        answer = 0;
        count = 0;
        for(int i=0; i<bridges.size(); i++){
            if(count == n-1){
                break;
            }
            Bridge br = bridges.get(i);
            if(union(br.island1, br.island2)){
                answer += br.cost;
                count++;
            }
        }
        return answer;
    }
    public boolean union(int num1, int num2){
        int p1 = find(num1);
        int p2 = find(num2);
        if(p1 != p2){
            parents[p2] = p1;
            return true;
        }
        return false;
    }
    public int find(int num){
        if(parents[num] != num){
            return find(parents[num]);
        }
        return num;
    }
    class Bridge implements Comparable<Bridge> {
        int island1;
        int island2;
        int cost;
        public Bridge(int[] arr){
            this.island1 = arr[0];
            this.island2 = arr[1];
            this.cost = arr[2];
        }
        @Override
        public int compareTo(Bridge br){
            // return this.cost - br.cost;
            return Integer.compare(this.cost, br.cost);
        }
    }
}