#include <iostream>
using namespace std;

int sumDigits(long num){
  int sum = 0;
  while(num != 0){
	sum += num%10;
	num/=10;
  }
  return sum;
}
//15 9    20
int main(){
  int t;
  cin >> t;
  while(t--){
    long n,left,right, val;
    int k;
    cin >> n >> k;
    left = n++;
    right = left + 1000000000000000000;
    while(left <= right) {
		val = (left-right)/2 + right;
		if(sumDigits(val) < k)
			left = val;
		else if(sumDigits(val) > k)
			right = val;
		else if(sumDigits(val) == k){
			break;
		}	
	}
    cout << val << endl;
  }
  return 0;
}
