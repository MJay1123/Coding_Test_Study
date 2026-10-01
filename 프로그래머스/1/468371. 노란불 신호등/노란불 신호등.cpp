#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> signals) {
    int n = signals.size();
    vector<vector<char>> signalVectors(n);
    vector<int> lengthVectors;
    int maxLength = 1;
    for(int r=0; r<n; r++){
        int green = signals[r][0];
        int yellow = signals[r][1];
        int red = signals[r][2];
        maxLength *= (green + yellow + red);
        lengthVectors.push_back(green+yellow+red);
        for(int i=0; i<green; i++){
            signalVectors[r].push_back('G');
        }
        for(int i=0; i<yellow; i++){
            signalVectors[r].push_back('Y');
        }
        for(int i=0; i<red; i++){
            signalVectors[r].push_back('R');
        }
    }
    int time = -1;
    for(int cur=0; cur<maxLength; cur++){
        bool shut_off = true;
        for(int r=0; r<n; r++){
            int index = cur % lengthVectors[r];
            if(signalVectors[r][index] != 'Y'){
                shut_off = false;
                break;
            }
        }
        if(shut_off){
            return cur + 1;
        }
    }
    return -1;
}