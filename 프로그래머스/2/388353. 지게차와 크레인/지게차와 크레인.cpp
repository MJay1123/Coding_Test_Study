#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;
static int R, C;
static vector<vector<int>> around = {{1,0},{0,1},{-1,0},{0,-1}};
static vector<vector<char>> map;
static vector<vector<bool>> visited;
static bool check_range(int r, int c){
    return r >= 0 && r < R+2 && c >= 0 && c < C+2;
}
static int count;
static void crane(char container){
    for(int r=0; r<R+2; r++){
        for(int c=0; c<C+2; c++){
            if(map[r][c] == container){
                map[r][c] = '.';
                count--;
            }
        }
    }
}
static void bfs(int sr, int sc, char container){
    for(int r=0; r<R+2; r++){
        for(int c=0; c<C+2; c++){
            visited[r][c] = false;
        }
    }
    queue<int> r_queue;
    queue<int> c_queue;
    r_queue.push(sr);
    c_queue.push(sc);
    while(!r_queue.empty()){
        int r = r_queue.front();
        r_queue.pop();
        int c = c_queue.front();
        c_queue.pop();
        for(int i=0; i<4; i++){
            int nr = r + around[i][0];
            int nc = c + around[i][1];
            if(check_range(nr, nc) && !visited[nr][nc]){
                if(map[nr][nc] == '.'){
                    r_queue.push(nr);
                    c_queue.push(nc);
                    visited[nr][nc] = true;
                } else if(map[nr][nc] == container){
                    visited[nr][nc] = true;
                    map[nr][nc] = '.';
                    count--;
                }
            }
        }
    }
}
int solution(vector<string> storage, vector<string> requests) {
    R = storage.size();
    C = storage[0].length();
    count = R * C;
    map = vector(R+2, vector<char>(C+2, '.'));
    visited = vector(R+2, vector<bool>(C+2, false));
    for(int r=0; r<storage.size(); r++){
        for(int c=0; c<storage[r].length(); c++){
            map[r+1][c+1] = storage[r][c];
        }
    }
    for(int i=0; i<requests.size(); i++){
        if(requests[i].length() == 1){
            char container = requests[i][0];
            bfs(0, 0, container);
        } else {
            char container = requests[i][0];
            crane(container);
        }
    }
    int answer = count;
    return answer;
}