#include <iostream>

using namespace std;

int findAllPaths(int m,int n)
{
     if (m == 1 || n == 1)
        return 1;

    return findAllPaths(m - 1, n) + findAllPaths(m, n - 1);
}

int main()
{
    int m,n;
    cout<<"Enter size of matrix: ";
    cin>> m >> n;

    cout<< findAllPaths(m,n);

    return 0;
}
