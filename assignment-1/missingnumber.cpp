#include <iostream>

using namespace std;

int getMissingNo(int a[],int n)
{
    int res = 0;
    for(int i=0;i<n;i++)
    {
        res = res ^ a[i];
    }
    for(int i=1;i<=n+1;i++)
    {
        res = res ^ i;
    }

    return res;
}

int main()
{
    int arr[] = {1, 2, 4, 6, 3, 7, 8};
    int n = sizeof(arr) / sizeof(arr[0]);

    cout<< getMissingNo(arr,n);
    return 0;
}
