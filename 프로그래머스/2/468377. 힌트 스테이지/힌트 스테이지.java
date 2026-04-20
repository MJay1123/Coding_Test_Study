class Solution {
    static int n;
    static int answer;
    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;
        answer = Integer.MAX_VALUE;
        int[] coupons = new int[n];
        solve(0, coupons, 0, cost, hint);
        return answer;
    }
    public static void solve(int stage, int[] coupons, int costSum, int[][] cost, int[][] hint){
        if(stage == n-1){
            int newCost = (coupons[stage] > n-1) ? costSum + cost[stage][n-1] : costSum + cost[stage][coupons[stage]];
            answer = Math.min(answer, newCost);
            return;
        }
        int newCost = (coupons[stage] > n-1) ? costSum + cost[stage][n-1] : costSum + cost[stage][coupons[stage]];
        int[] hints = hint[stage];
        for(int i=1; i<hints.length; i++){
            coupons[hints[i]-1]++;
        }
        solve(stage+1, coupons, newCost+hints[0], cost, hint);
        for(int i=1; i<hints.length; i++){
            coupons[hints[i]-1]--;
        }
        solve(stage+1, coupons, newCost, cost, hint);
    }
}