#include <iostream>

using namespace std;

int getInversions(int a[],int n )
{
    int inversion=0;
    for(int i=0;i<n-1;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(a[i]>a[j])
                inversion++;
        }
    }
    return inversion;
}

int main()
{
    int arr[]={8, 4, 2, 1};
    int n= sizeof(arr)/sizeof(arr[0]);

    cout<< getInversions(arr,n);

    return 0;
}
