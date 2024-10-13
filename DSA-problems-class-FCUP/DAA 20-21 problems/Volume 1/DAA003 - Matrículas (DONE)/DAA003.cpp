#include <iostream>
using namespace std;



class Plate{
	private:
	bool isNumber(char c){
		return c >='0' && c<='9';
	}

	bool isLetter(char c){
		return c>='A' && c<='Z';
	}
	
	public:
	string code;
	int generation;
	Plate(string str){
		if(isLetter(str[0]) && isNumber(str[str.length()-1]){
			this.generation = 1;
		}	
		else if(isNumber(str[0]) && isLetter(str[str.length()-1]){
			this.generation = 2;
		}	
		else if(isNumber(str[0]) && isNumber(str[str.length()-1]){
			this.generation = 3;
		}	
		else{
			this.generation = 4;
		}
			
	}
	
};

int main(){
	int t;
	cin >> t;
	while(t--){
		string str1, str2;
		cin >> str1 >> str2;
		Plate p1 = new Plate(p1);
		Plate p2 = new Plate(p2);
		cout << p1.generation << " " << p2.generation << endl;
	} 
  return 0;
}
