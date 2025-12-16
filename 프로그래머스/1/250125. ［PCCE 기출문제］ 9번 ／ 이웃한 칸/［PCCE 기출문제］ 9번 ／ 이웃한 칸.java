class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        String color = board[h][w];
        int[] dh = new int[4];
        int[] dw = new int[4];
        dh = new int[] {0,1,-1,0};
        dw = new int[] {1,0,0,-1};
        for(int i=0; i<4; i++){
            int nh = h + dh[i];
            int nw = w + dw[i];
            if(nh >= 0 & nh < n & nw >= 0 & nw < n){
                if(board[nh][nw].equals(color)){
                    answer++;
                }
            }
        }
        return answer;
    }
}