#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void printAllPermutations(string str, int i, int n)
{
    if (i == n - 1)
    {
        cout << str << endl;
        return;
    }

    for (int j = i; j < n; j++)
    {

        swap(str[i], str[j]);

        printAllPermutations(str, i + 1, n);

        swap(str[i], str[j]);
    }
}

int main()
{
    string str = "ABC";

    printAllPermutations(str, 0, str.length());

    return 0;
}
