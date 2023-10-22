//  ███╗  ██╗ ███╗   ███╗ ███╗  ██╗ ███╗   ███╗
//  ████╗ ██║ ████╗ ████║ ████╗ ██║ ████╗ ████║
//  ██╔██╗██║ ██╔████╔██║ ██╔██╗██║ ██╔████╔██║
//  ██║╚████║ ██║╚██╔╝██║ ██║╚████║ ██║╚██╔╝██║
//  ██║ ╚███║ ██║ ╚═╝ ██║ ██║ ╚███║ ██║ ╚═╝ ██║
//  ╚═╝  ╚══╝ ╚═╝     ╚═╝ ╚═╝  ╚══╝ ╚═╝     ╚═╝


#include <bits/stdc++.h>
using namespace std;
#define fn(n) for(int i=0;i<n;i++)
#define ll long long
void fast(){
    ios_base ::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
}


void strandSort(list<int>& input, list<int>& output) {
    if (input.empty())
        return;

    list<int> sublist;
    sublist.push_back(input.front());
    input.pop_front();

    for (auto it = input.begin(); it != input.end();) {
        if (*it > sublist.back()) {
            sublist.push_back(*it);
            it = input.erase(it);
        } else {
            ++it;
        }
    }

    output.merge(sublist);
    strandSort(input, output);
}

int main() {
    fast();
    list<int> input {10, 5, 30, 40, 2, 4, 9};
    list<int> output;
    strandSort(input, output);

    for (const auto& item : output) {
        cout << item << " ";
    }
    cout << endl;

    return 0;
}
