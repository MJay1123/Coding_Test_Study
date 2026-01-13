import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int caseNumber = 1; caseNumber <= 10; caseNumber++){

            int length = Integer.parseInt(br.readLine());
            String[][] matrix = new String[8][8];
            for(int i=0; i<8; i++){
                String[] temp = br.readLine().split("");
                for(int j=0; j<8; j++){
                    matrix[i][j] = temp[j];
                }
            }
//            System.out.println(length);
//            for(int i=0; i<8; i++){
//                System.out.println(Arrays.toString(matrix[i]));
//            }
            int count = 0;

            // 가로줄 체크!
            for(int r=0; r<8; r++){
                String[] array = new String[length];
                for(int c=0; c<=8-length; c++){
                    for(int i=0; i<length; i++){
                        array[i] = matrix[r][c+i];
                    }
                    if(checkSymmetrical(array, length)){
                        count++;
                    }
                }
            }

            // 세로줄 체크!
            for(int c=0; c<8; c++){
                String[] array = new String[length];
                for(int r=0; r<=8-length; r++){
                    for(int i=0; i<length; i++){
                        array[i] = matrix[r+i][c];
                    }
                    if(checkSymmetrical(array, length)){
                        count++;
                    }
                }
            }

            bw.write("#" + caseNumber + " " + count + "\n");


        }
        bw.flush();
    }

    public static boolean checkSymmetrical(String[] array, int length){
        for(int i=0; i<=length/2 - 1; i++){
            String front = array[i];
            String back = array[length-1-i];
            if(front.equals(back)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
