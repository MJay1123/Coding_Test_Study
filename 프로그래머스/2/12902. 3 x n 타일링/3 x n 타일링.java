class Solution {
    static long[][] memo;
    static int MOD = 1000000007;
    public int solution(int n) {
        memo = new long[2][n+1];     // 오른쪽 끝에 세로방향 블럭이 없다(0) / 있다(1)
        if(n >= 2){
            memo[0][2] = 1;
            memo[1][2] = 2;
        }
        // if(n >= 4){
        //     memo[4] = memo[2] * memo[2] + 2;
        // }
        // if(n >= 6){
        //     memo[6] = memo[2] * memo[4] + memo[4] * memo[2] - memo[2] * memo[2] * memo[2] + 2;
        // }
        for(int i=4; i<=n; i+=2){
            memo[0][i] = (memo[0][i-2] + memo[1][i-2]) % MOD;
            memo[1][i] += (memo[0][i-2] * 2 + memo[1][i-2] * 3) % MOD;
        }
        int answer = (int)(memo[0][n] + memo[1][n]) % MOD;
        return answer;
    }
}