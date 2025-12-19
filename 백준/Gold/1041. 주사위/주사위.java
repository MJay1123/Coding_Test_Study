

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주사위
public class Main {
    static long N;               // 정육면체 한 변의 길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Long.parseLong(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] num = new int[6];
        for(int i=0; i<6; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Math.min(num[i], num[5-i]);        // 반대편에 있는 수 중에 1개만 사용 가능
        }
        Arrays.sort(arr);

        long threeFace = 4;
        long twoFace = 4 + 8*(N-2);
        long oneFace = (N-2)*(N-2)*5 + 4*(N-2);

        long answer = 0;
        answer += threeFace * (arr[0]+arr[1]+arr[2]);
        answer += twoFace * (arr[0]+arr[1]);
        answer += oneFace * arr[0];

        if (N == 1){
            Arrays.sort(num);
            answer = num[0] + num[1] + num[2] + num[3] + num[4];
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}

/*
* 2x2x2 - 8 - 0 = 8
* 6 - 4
* 3 - 4
* 1 - 0
* 36
*
* 3x3x3 - 27 - 2 = 25
* 6 - 4
* 3 - 4+8
* 1 - 1x5 + 4x1
* 69
*
* 4x4x4 - 64 - 12 = 52
* 6 - 4
* 3 - 4+8+8
* 1 - 4x5 + 4x2
* 113
*
* 5x5x5
* 6 - 4
* 3 - 4+8+8+8
* 1 - 9x5 + 4x3
*
* 6x6x6
* 6 - 4
* 3 - 4+8+8+8+8
* 1 - 16x5 + 4x4
*
* */
