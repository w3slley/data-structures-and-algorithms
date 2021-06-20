#include <bits/stdc++.h>
using namespace std;

int fib(int n){
  unordered_map <int, int> fib;
  for(int i=0;i<n;i++){
    int f;
    if(i < 2) f = i;
    else
      f = fib[i-1] + fib[i-2];
    fib[i] = f;
  }
  return fib[n-1] + fib[n-2];
}

int main(){
  int n;
  cin >> n;
  
  cout << fib(n) << endl;
  return 0;
}
