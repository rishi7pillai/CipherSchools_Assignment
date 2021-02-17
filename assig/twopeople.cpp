#include<iostream>

using namespace std;

bool doTheyMeet(int x1,int x2,int v1,int v2)
{
    //1st condition where they would never meet
    if(x1>x2 && v1>=v2)
    {
        return false;
    }
    //2nd condition where they would not meet
    if(x2>x1 && v2>=v1)
    {
        return false;
    }

    //To make sure x1 is ahead of x2
    if( x2 > x1 )
    {
        swap(x1,x2);
        swap(v1,v2);
    }
    int D = x1-x2;
    int V = v1-v2;
    //to find if they meet or not
    if( D % V == 0)
        return true;

    return false;

}

int main()
{

    int x1,x2,v1,v2;
    cin >>x1>>v1>>x2>>v2;
    if(doTheyMeet(x1,x2,v1,v2))
        cout<<"Yes";
    else
        cout<<"No";
    return 0;
}
