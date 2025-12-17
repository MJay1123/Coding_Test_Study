class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (compare(wallet, bill)){
            fold(bill);
            answer++;
        }
        return answer;
    }
    private static void fold(int[] bill){
        if(bill[0] >= bill[1]){
            bill[0] /= 2;
        } else {
            bill[1] /= 2;
        }
    }
    private static boolean compare(int[] wallet, int[] bill){
        if(Math.max(wallet[0], wallet[1]) < Math.max(bill[0], bill[1])){
            return true;
        }
           if(Math.min(wallet[0], wallet[1]) < Math.min(bill[0], bill[1])){
               return true;
           }
           return false;
    }
}
           