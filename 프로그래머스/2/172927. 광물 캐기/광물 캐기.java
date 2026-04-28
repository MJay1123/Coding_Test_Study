import java.util.*;
class Solution {
    static int M;       // mineralList의 수
    static int P = 0;   // pickaxe의 수
    static int minimumTired = 25*50;
    static int tired = 0;
    static int[][] mine = {{1,1,1},{5,1,1},{25,5,1}};  // 0 : 다이아몬드, 1 : 철, 2 : 돌
    static List<Integer> pickaxeList = new ArrayList<>();
    static List<int[]> mineralList = new ArrayList<>();
    public int solution(int[] picks, String[] minerals) {
        for(int i=0; i<3; i++){
            P += picks[i];
        }
        
        int index = 0;
        while(true){
            int[] array = new int[3];
            for(int i=index; i<index+5; i++){
                if(i < minerals.length){
                    switch(minerals[i]){
                        case "diamond" :
                            array[0]++;
                            break;
                        case "iron" :
                            array[1]++;
                            break;
                        case "stone" :
                            array[2]++;
                            break;
                    }
                }
            }
            mineralList.add(array);             // 광물 5개씩 배열로 묶어서 리스트에 저장
            
            index += 5;
            if(index >= minerals.length){
                break;
            }
        }
        M = mineralList.size();
        choosePickaxe(picks);
        return minimumTired;
    }
    
    public void choosePickaxe(int[] picks){
        if(pickaxeList.size() == P){                                            // 곡괭이 배열 완성
            tired = 0;
            for(int i=0; i<Math.min(P, M); i++){
                int pickaxe = pickaxeList.get(i);
                int[] mineralCount = mineralList.get(i);                        // [다이아몬드, 철, 돌]
                for(int mineral=0; mineral<3; mineral++){
                    tired += mine[pickaxe][mineral] * mineralCount[mineral];    // 곡괭이x광물 피로도 추가
                }
            }
            minimumTired = Math.min(minimumTired, tired);
            return;
        }
        if(picks[0] > 0){
            pickaxeList.add(0);
            picks[0]--;
            choosePickaxe(picks);
            picks[0]++;
            pickaxeList.remove(pickaxeList.size()-1);
        }
        if(picks[1] > 0){
            pickaxeList.add(1);
            picks[1]--;
            choosePickaxe(picks);
            picks[1]++;
            pickaxeList.remove(pickaxeList.size()-1);
        }
        if(picks[2] > 0){
            pickaxeList.add(2);
            picks[2]--;
            choosePickaxe(picks);
            picks[2]++;
            pickaxeList.remove(pickaxeList.size()-1);
        }
    }
}