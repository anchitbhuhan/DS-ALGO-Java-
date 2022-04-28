//====================Print Linearly from N to 1=====================================//

#include <iostream>

using namespace std;
void print(int n);

int main ()
{
  int num;

  cout << "Enter the value of N : " << endl;
  cin >> num;

  print (num);
  return 0;
}

void print (int n)
{
    if (n <= 0)
        return;
    cout << n << endl;
    print(n-1);
}
