#include <iostream>

using namespace std;

void find1stLast(int a[],int n,int x)
{
    int first = -1, last = -1;
    for (int i = 0; i < n; i++) {
        if (x != a[i])
            continue;
        if (first == -1)
            first = i;
        last = i;
    }
    if (first != -1)
    {
        cout << "First Occurrence= " << first<<endl;
        cout<< "Last Occurrence= " << last;
    }
    else
        cout << "Not Found";
}
int main()
{
    int arr[]={2,3,6,6,6,6,6,34,43,55,261};
    int n=sizeof(arr)/sizeof(arr[0]);
    int k= 6;
    find1stLast(arr,n,k);
    return 0;
}
