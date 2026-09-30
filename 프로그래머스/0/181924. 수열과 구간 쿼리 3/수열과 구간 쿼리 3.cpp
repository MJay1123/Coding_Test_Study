#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    for(int i=0; i<queries.size(); i++){
        int index1 = queries[i][0];
        int index2 = queries[i][1];
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    for(int i=0; i<arr.size(); i++){
        answer.push_back(arr[i]);
    }
    return answer;
}