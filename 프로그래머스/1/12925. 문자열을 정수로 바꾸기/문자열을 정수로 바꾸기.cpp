#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    int temp = 1;
    if(s[0] == '+'){
        temp = 1;
    } else if(s[0] == '-'){
        temp = -1;
    } else {
        answer = (s[0] - '0');
    }
    for(int i=1; i<s.length(); i++){
        answer *= 10;
        answer += (s[i] - '0');
    }
    answer *= temp;
    return answer;
}