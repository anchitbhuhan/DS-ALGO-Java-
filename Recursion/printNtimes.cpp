#include <iostream>

using namespace std;
void print(int n);

int main ()
{
  int num;

  cout << "Enter the number of times to be printed : " << endl;
  cin >> num;

  print (num);
  return 0;
}

void print (int n)
{
    if (n <= 0)
        return;
    cout << "Anchit" << endl;
    print(--n);
}
