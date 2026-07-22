class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int low = 1;
        int high = 100001;
        int middle = 0;
        int answer = 0;
        while(low < high){
            middle = (low + high) / 2;
            if(solve(middle, diffs, times) <= limit){
                answer = middle;
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return answer;
    }
    
    public static long solve(int level, int[] diffs, int[] times) {
        long time = 0;
        time += times[0];
        for(int i=1; i<diffs.length; i++){
            if(level >= diffs[i]){
                time += times[i];
            } else {
                time += (times[i-1] + times[i]) * (diffs[i] - level) + times[i];
            }
        }
        return time;
    }
}