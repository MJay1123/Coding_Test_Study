#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numLog) {
    string answer = "";
    for(int i=1; i<numLog.size(); i++){
        int d = numLog[i] - numLog[i-1];
        if(d == 1){
            answer = answer + 'w';
        } else if(d == -1){
            answer = answer + 's';
        } else if(d == 10){
            answer = answer + 'd';
        } else if(d == -10){
            answer = answer + 'a';
        }
    }
    return answer;
}