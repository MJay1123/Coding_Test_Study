class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        answer = new int[photo.length];
        for (int r=0; r<photo.length; r++){
            for (int c=0; c<photo[r].length; c++){
                for (int i=0; i<name.length; i++){
                    if(photo[r][c].equals(name[i])){
                        answer[r] += yearning[i];
                    }
                }
            }
        }
        return answer;
    }
}