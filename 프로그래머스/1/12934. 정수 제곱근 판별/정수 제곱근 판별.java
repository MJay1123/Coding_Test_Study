class Solution {
    public long solution(long n) {
        long left = 1L;
        long right = 80000000L;
        while(left <= right){
            long middle = (left + right) / 2;
            if(middle * middle == n){
                return (middle + 1) * (middle + 1);
            } else if(middle * middle < n){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}