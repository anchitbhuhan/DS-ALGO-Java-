//====================Sum of First N Numbers==================================//
#include <iostream>

using namespace std;


int sum(int n);

int main()
{
    int n;
    
    cout << "Enter the value of N: " << endl;
    cin >> n;

    int res = sum(n);
    
    cout << "Sum = " << res << endl;
    return 0;
}

int sum(int n)
{
    if(n <= 0)
        return 0;
    else
        return n + sum(n-1);
}
