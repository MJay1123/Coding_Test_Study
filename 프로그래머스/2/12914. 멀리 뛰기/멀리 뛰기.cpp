#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

long long solution(int n) {
    if(n == 1){
        return 1;
    } else if(n == 2){
        return 2;
    } else {
        vector<int> v;
        v.push_back(0);
        v.push_back(1);
        v.push_back(2);
        for(int i=3; i<=n; i++){
            v.push_back((v[i-2] + v[i-1]) % 1234567);
        }
        return v[v.size()-1];
    }
}