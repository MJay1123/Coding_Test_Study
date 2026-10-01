#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    vector<int> numbers;
    while(n > 0){
        numbers.push_back(n % 10);
        n /= 10;
    }
    sort(numbers.rbegin(), numbers.rend());
    long long answer = 0;
    for(int i=0; i<numbers.size(); i++){
        answer *= 10;
        answer += numbers[i];
    }
    return answer;
}