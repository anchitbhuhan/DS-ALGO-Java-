//====================Print Reverse of Array==================================//
#include <iostream>
#include <vector>

using namespace std;


void printrev(int i, vector<int> V);

int main()
{
    int n, temp;
    vector<int> V;
    
    cout << "Enter the value of N: " << endl;
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> temp;
        V.push_back(temp);
    }
    
    printrev(0, V);
    return 0;
}

void printrev(int i, vector<int> V)
{
    if(i == V.size())
        return;
    else
    {
        printrev(i+1, V);
        cout << V[i] << " ";
    }
}
