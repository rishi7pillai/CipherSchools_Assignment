#include <iostream>
#include <algorithm>

using namespace std;

int binarySearch(int a[],int n,int k)
{
    int l = 0;
    int r = n-1;
    int mid;
    while( l <= r)
    {
        mid = ( l+r )/2;
        if(a[mid] == k)
            return mid;
        else if( k< a[mid])
            r = mid-1;
        else
            l = mid+1;
    }
    return -1;
}

int main()
{
    int arr[] = {3,10,11,19,23,28,32,43};
    int n = sizeof(arr)/sizeof(arr[0]);

    int k = 19;

    int idx = binarySearch(arr, n, k);

    if( idx == -1)
        cout<<" Item not Found ";
    else
    {
        cout<< "Item "<< k <<" found at index: ";
        cout<< idx;
    }
    return 0;
}
