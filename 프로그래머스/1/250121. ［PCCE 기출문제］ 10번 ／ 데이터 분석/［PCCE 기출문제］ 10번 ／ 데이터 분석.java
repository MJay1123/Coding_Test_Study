import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] extArray = new String[]{"code", "date", "maximum", "remain"};
        int index = 0;
        for(int i=0; i<4; i++){
            if(ext.equals(extArray[i])){
                index = i;
            }
        }
        List<Integer> indexList = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            if(data[i][index] < val_ext){
                indexList.add(i);
            }
        }
        for(int i=0; i<4; i++){
            if(sort_by.equals(extArray[i])){
                index = i;
            }
        }
        List<Integer> sortList = new ArrayList<>();
        for(int i=0; i<indexList.size(); i++){
            sortList.add(data[indexList.get(i)][index]);
        }
        Collections.sort(sortList);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<sortList.size(); i++){
            for(int j=0; j<indexList.size(); j++){
                if(data[indexList.get(j)][index] == sortList.get(i)){
                    list.add(indexList.get(j));
                }
            }
        }
        int[][] answer = new int[list.size()][data[0].length];
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<data[0].length; j++){
                answer[i][j] = data[list.get(i)][j];
            }
        }
        return answer;
    }
}