#include <string>
#include <vector>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    for(int num=l; num<=r; num++){
        int i = num;
        bool bl = true;
        while(i > 0){
            if(i % 10 == 0 || i % 10 == 5){
                i /= 10;
            } else {
                bl = false;
                break;
            }
        }
        if(bl){
            answer.push_back(num);
        }
    }
    if(answer.size() == 0){
        answer.push_back(-1);
    }
    return answer;
}