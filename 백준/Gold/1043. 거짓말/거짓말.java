import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 사람의 수
        int M = Integer.parseInt(st.nextToken());   // 파티의 수
        st = new StringTokenizer(br.readLine());
        boolean[] knowTruth = new boolean[N+1];
        boolean[] parties = new boolean[M];
        int T = Integer.parseInt(st.nextToken());   // 진실을 아는 사람의 수
        for(int i=0; i<T; i++){
            int num = Integer.parseInt(st.nextToken());
            knowTruth[num] = true;
        }
        boolean[][] participation = new boolean[M][N+1];
        for(int party=0; party<M; party++){
            st = new StringTokenizer(br.readLine());
            int participationCount = Integer.parseInt(st.nextToken());
            for(int i=0; i<participationCount; i++){
                int num = Integer.parseInt(st.nextToken());
                participation[party][num] = true;
                if(knowTruth[num]){
                    parties[party] = true;
                }
            }
        }
        for(int party=M-1; party>=0; party--){
            if(parties[party]){
                changeParty(party, participation, parties, knowTruth);
            }
        }
        for(int i=0; i<M; i++){
            if(!parties[i]){
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }

    public static void changeParty(int partyIndex, boolean[][] participation, boolean[] parties, boolean[] knowTruth){
        for(int i=1; i<participation[0].length; i++){
            if(participation[partyIndex][i] && !knowTruth[i]){
                knowTruth[i] = true;
                for(int j=0; j<participation.length; j++){
                    if(participation[j][i]){
                        parties[j] = true;
                        changeParty(j, participation, parties, knowTruth);
                    }
                }
            }
        }
    }
}
