class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int hp = health;
        for(int i=0; i<attacks.length-1; i++){
            hp -= attacks[i][1];
            if(hp <= 0){
                return -1;
            }
            int healTime = attacks[i+1][0] - attacks[i][0] - 1;
            hp += healTime / bandage[0] * bandage[2] + healTime * bandage[1];
            if(hp > health){
                hp = health;
            }
            time = attacks[i][0];
        }
        hp -= attacks[attacks.length-1][1];
        if(hp <= 0){
            return -1;
        }
        return hp;
    }
}