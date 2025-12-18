import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int f = friends.length;
        int[] giftScore = new int[f];           // 선물 지수
        int[][] giftNumber = new int[f][f];     // 주고 받은 선물
        int[] giftCount = new int[f];           // 받을 선물
        for(int i=0; i<gifts.length; i++){
            String[] gift = gifts[i].split(" ");
            String giver = gift[0];
            String receiver = gift[1];
            int giveIndex = 0;
            int receiveIndex = 0;
            for(int j=0; j<f; j++){
                if(friends[j].equals(giver)){
                    giveIndex = j;
                }
                if(friends[j].equals(receiver)){
                    receiveIndex = j;
                }
            }
            giftNumber[giveIndex][receiveIndex]++;
        }
        for(int i=0; i<f; i++){
            for(int j=0; j<f; j++){
                giftScore[i] += giftNumber[i][j];       // 준 선물
                giftScore[i] -= giftNumber[j][i];       // 받은 선물
            }
        }
        for(int i=0; i<f; i++){
            for(int j=0; j<f; j++){
                if(i == j){
                    continue;
                }
                if(giftNumber[i][j] > giftNumber[j][i]){
                    giftCount[i]++;
                } else if(giftNumber[i][j] == giftNumber[j][i] && giftScore[i] > giftScore[j]){
                    giftCount[i]++;
                }
            }
        }
        for(int i=0; i<f; i++){
            answer = Math.max(answer, giftCount[i]);
        }
        return answer;
    }
}