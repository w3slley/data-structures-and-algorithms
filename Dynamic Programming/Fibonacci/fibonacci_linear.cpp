#include <bits/stdc++.h>
using namespace std;

int fib(int n){
  if(n == 0 || n == 1) return n;

  int f1 = 1;
  int f2 = 0;
  int f;
  for(int i=2;i<n;i++){
    f = f1 + f2;
    f2 = f1;
    f1 = f;
  }
  f = f1+f2;
  return f;
}

int main(){
  int n;
  cin >> n;
  cout << fib(n) << endl;
  return 0;
}
