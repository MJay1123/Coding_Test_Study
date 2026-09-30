#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    int minimum = min(a, b);
    int maximum = max(a, b);
    for(int i=minimum; i<=maximum; i++){
        answer += i;
    }
    return answer;
}