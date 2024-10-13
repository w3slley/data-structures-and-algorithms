#include <bits/stdc++.h>
using namespace std;

int main(){
  int n;
  int c = 0;
  cin >> n;
  while(n--){
    int num;
    cin >> num;
    if(num == 42) ++c;
  }
  cout << c << endl;
  return 0;
}
