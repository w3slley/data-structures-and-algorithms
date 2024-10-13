#include <cstdio>
#include <cstring>
#include <queue>
#include <iostream>
using namespace std;

int W, H;
int Maze[300][300];
int scale = 3;
struct point_type{
  int i;
  int j;
};

void Write_Maze(char line[], int i){
  //cout << line << '\n';
  for(int j=0;line[j];++j){
    int ii=i*scale, jj=j*scale;
    for (int x = 0; x < scale; ++x){
      for (int y = 0; y < scale; ++y){
	Maze[ii+x][jj+y] = 0;
      }
    }
    if (line[j] == '\\') {
      for(int k=0;k<scale;k++){
	Maze[ii+k][jj+k] = 1;
      }
    }
    else {
      for(int k=0;k<scale;k++){
	Maze[ii+k][jj+scale-k-1] = 1;
      }
    }
  }
    
}
const int direction[][2] = {{-1,0},{1,0},{0,-1},{0,1}};
bool Run_Maze(int i, int j, int &longest)
{
  queue<point_type> Q;
  Q.push({i,j});
  int length = 1;
  bool isCycle = 1;
  point_type cur, nxt;
  while (!Q.empty()) {
    length++;
    cur = Q.front();
    Q.pop();

    for (int x = 0; x < 4; ++x) {
      nxt.i = cur.i + direction[x][0];
      nxt.j = cur.j + direction[x][1];
      if (nxt.i < 0 || nxt.j < 0 || nxt.i >= H || nxt.j >= W) {
	isCycle = 0;
	continue;
      }
      if (Maze[nxt.i][nxt.j] == 0) {
	Maze[nxt.i][nxt.j] = 1;
	Q.push(nxt);
      }
    }
  }
  if (isCycle == 0) return 0;
  length /= scale;
  if (longest < length) longest = length;
  return 1;
}
void showMaze(){
  for(int i=0;i<H;i++){
    for(int j=0;j<W;j++){
      cout << Maze[i][j] << " ";
    }
    cout << endl;
  }
}
int main(){
  char line[100];
  scanf("%d %d", &W, &H);
  for (int i = 0; i < H; ++i){
    scanf("%s", line);
    Write_Maze(line, i);
  }
  H *= scale;
  W *= scale;
  

  int numOfCycles = 0;
  int longest = 0;
  for (int i = 0; i < H; ++i)
    for (int j = 0; j < W; ++j){
      if(Maze[i][j] == 0){
	showMaze();
	if(Run_Maze(i, j, longest))
	  numOfCycles++;
	cout << endl;
      }
    }
  if (numOfCycles)
    printf("%d %d\n", numOfCycles, longest);
  else
    printf("nao tem ciclos\n");
    
}
