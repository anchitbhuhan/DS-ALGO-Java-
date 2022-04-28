#include <iostream>

using namespace std;
void print(int start, int n);

int main ()
{
  int num;

  cout << "Enter the value of N : " << endl;
  cin >> num;

  print (1, num);
  return 0;
}

void print (int start, int n)
{
    if (start > n)
        return;
    cout << start << endl;
    print(start+1, n);
}
