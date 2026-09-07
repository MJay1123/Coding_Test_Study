class Solution {
    static int[] parents;
    static int networks;
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        networks = n;
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(computers[r][c] == 1){
                    union(r, c);
                }
            }
        }
        return networks;
    }
    public void union(int num1, int num2){
        int p1 = find(num1);
        int p2 = find(num2);
        if(p1 != p2){
            parents[p2] = p1;
            networks--;
        }
    }
    public int find(int num){
        if(parents[num] != num){
            return find(parents[num]);
        }
        return num;
    }
}