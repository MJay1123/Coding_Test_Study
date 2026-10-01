#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
int R, C;
int sr, sc, lr, lc, er, ec;
vector<vector<char>> map;
vector<vector<int>> around = {{1,0},{0,1},{-1,0},{0,-1}};
bool checkRange(int r, int c){
    return r >= 0 && r < R && c >= 0 && c < C;
}
int BFS(int start_r, int start_c, char goal){
    cout << "bfs start" << endl;
    queue<int> r_queue;
    queue<int> c_queue;
    queue<int> d_queue;
    vector<vector<bool>> visited(R, vector<bool>(C, false));
    r_queue.push(start_r);
    c_queue.push(start_c);
    d_queue.push(0);
    while(!r_queue.empty()){
        int r = r_queue.front();
        r_queue.pop();
        int c = c_queue.front();
        c_queue.pop();
        int d = d_queue.front();
        d_queue.pop();
        cout << r << " " << c << " " << d << " " << endl;
        if(map[r][c] == goal){
            return d;
        }
        for(int i=0; i<4; i++){
            int nr = r + around[i][0];
            int nc = c + around[i][1];
            if(checkRange(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'X'){
                r_queue.push(nr);
                c_queue.push(nc);
                d_queue.push(d + 1);
                visited[nr][nc] = true;
            }
        }
    }
    return -1;
}
int solution(vector<string> maps) {
    R = maps.size();
    C = maps[0].length();
    map = vector(R, vector<char>(C));
    for(int r=0; r<R; r++){
        for(int c=0; c<C; c++){
            map[r][c] = maps[r][c];
            if(map[r][c] == 'S'){
                sr = r;
                sc = c;
            }
            if(map[r][c] == 'L'){
                lr = r;
                lc = c;
            }
            if(map[r][c] == 'E'){
                er = r;
                ec = c;
            }
        }
    }
    int dist1 = BFS(sr, sc, 'L');
    int dist2 = BFS(lr, lc, 'E');
    int answer = 0;
    if(dist1 == -1 || dist2 == -1){
        answer = -1;
    } else {
        answer = dist1 + dist2;
    }
    return answer;
}