#include <iostream>
#include <string>
using namespace std;

int sumDigits(string str){
  int sum = 0;
  for(auto it=str.begin();it!=str.end();++it){
    int d = *it-'0';
    sum+=d;
  }
  return sum;
}
int main(){
  int t;
  cin >> t;
  while(t--){
    int n,k;
    cin >> n >> k;
    n++;
    while(sumDigits(to_string(n))!=k) n++;
    cout << n << endl;
  }
  return 0;
}
