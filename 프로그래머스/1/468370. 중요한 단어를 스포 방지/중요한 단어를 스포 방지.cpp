#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <map>
#include <set>

using namespace std;

int solution(string message, vector<vector<int>> spoiler_ranges) {
    vector<int> spaces;
    spaces.push_back(-1);
    for(int i=0; i<message.length(); i++){
        if(message[i] == ' '){
            spaces.push_back(i);
        }
    }
    spaces.push_back(message.length());
    set<string> outside_words;
    set<string> revealed_words;
    for(int i=1; i<spaces.size(); i++){
        int left = spaces[i-1] + 1;
        int right = spaces[i] - 1;
        string word = message.substr(left, right-left+1);
        bool outside = true;
        for(int j=0; j<spoiler_ranges.size(); j++){
            int start = spoiler_ranges[j][0];
            int end = spoiler_ranges[j][1];
            if(right < start || end < left){
                continue;
            } else {
                outside = false;
                break;
            }
        }
        if(outside){
            outside_words.insert(word);
        }
    }
    int answer = 0;
    for(int r=0; r<spoiler_ranges.size(); r++){
        int start = spoiler_ranges[r][0];
        int end = spoiler_ranges[r][1];
        int left = start;
        while(left >= 0){
            if(message[left] == ' '){
                break;
            }
            left--;
        }
        int right = end;
        while(right < message.length()){
            if(message[right] == ' '){
                break;
            }
            right++;
        }
        int ls, rs;
        for(int i=0; i<spaces.size(); i++){
            if(spaces[i] == left){
                ls = i;
            }
            if(spaces[i] == right){
                rs = i;
            }
        }
        for(int i=ls+1; i<=rs; i++){
            int index = spaces[i-1]+1;
            int length = spaces[i]-spaces[i-1]-1;
            string word = message.substr(index, length);
            if(outside_words.contains(word)){
                continue;
            } else {
                if(revealed_words.contains(word)){
                    continue;
                } else {
                    answer++;
                    revealed_words.insert(word);
                }
            }
        }
    }
    return answer;
}