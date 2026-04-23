import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new ArrayList<>();
        List<Double> areaList = new ArrayList<>();
        int current = k;
        list.add(k);
        double area = 0.0;
        areaList.add(area);
        while(true){
            int next = (current % 2 == 0) ? current / 2 : current * 3 + 1;
            list.add(next);
            area = getArea(area, current, next);
            areaList.add(area);
            if(next == 1){
                break;
            }
            current = next;
        }
        double[] answer = new double[ranges.length];
        for(int i=0; i<ranges.length; i++){
            int[] range = ranges[i];
            int s = range[0];
            int e = list.size() - 1 + range[1];
            answer[i] = (s <= e) ? areaList.get(e) - areaList.get(s) : -1.0;
        }
        return answer;
    }
    public static double getArea(double area, int current, int next){
        double newArea = (current + next) / 2.0;
        return area + newArea;
    }
}