//====================Factorial of N==================================//
#include <iostream>

using namespace std;


int fact(int n);

int main()
{
    int n;
    
    cout << "Enter the value of N: " << endl;
    cin >> n;

    int res = fact(n);
    
    cout << "Factorial = " << res << endl;
    return 0;
}

int fact(int n)
{
    if(n <= 0)
        return 1;
    else
        return n * fact(n-1);
}
