class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int[] index = new int[3];
        boolean possible = true;
        while(index[2] < goal.length){
            if(index[0] < cards1.length && cards1[index[0]].equals(goal[index[2]])){
                index[0]++;
                index[2]++;
                continue;
            }
            if(index[1] < cards2.length && cards2[index[1]].equals(goal[index[2]])){
                index[1]++;
                index[2]++;
                continue;
            }
            possible = false;
            break;
        }
        if(possible){
            return "Yes";
        } else {
            return "No";
        }
    }
}
