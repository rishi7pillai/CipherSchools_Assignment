#include <iostream>
#include<cmath>
#include<algorithm>

using namespace std;

int majorNaive(int a[],int n)
{
    int cnt,maxc=0;
    int idx=-1;;
    for(int i=0;i<n;i++)
    {
        cnt =0;
        for(int j=0;j<n;j++)
        {
            if(a[i] == a[j])
                cnt++;
            if(cnt > maxc)
            {
                maxc=cnt;
                idx=i;
            }
        }
    }
        if(maxc > n/2)
            return a[idx];
        else
            return -1;
}

int majorUsingSort(int a[],int n)
{
    sort(a,a+n);
    int count=1,prev = a[0],maxc=-1;
    int element,flag=0;
    for(int i=1;i<n;i++)
    {
        if(a[i] == prev)
            count++;
        else
        {
            count =1;
            prev = a[i];
        }
        if(count > maxc)
        {
            maxc = count;
            element = a[i];
            if( maxc > n/2)
            {
                flag =1;
                break;
            }
        }
    }
    if( flag == 0)
        return -1;
    else
        return element;

}

int main()
{
    int arr[]={3, 3, 4, 2, 4, 4, 2, 4, 4};
    int n = sizeof(arr)/sizeof(arr[0]);
    int res = majorUsingSort(arr,n);
    if(res == -1)
        cout<<"No Majority Element";
    else
        cout<< res;

    return 0;
}
