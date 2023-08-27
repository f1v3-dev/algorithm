#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() 
{
    // {점수 : 문제 번호}
    vector<pair<int, int>> list(8);

    for (int i = 0; i < 8; i++) {
        // 점수 입력 후 문제번호 넣어주기
        cin >> list[i].first;
        list[i].second = i + 1;
    }

    // greater : 내림차순 정렬
    sort(list.begin(), list.end(), greater < pair<int, int>>());

    int sum = 0;
    vector<int> num;

    for (int i = 0; i < 5; i++) {
        sum += list[i].first;
        num.push_back(list[i].second);
    }

    // 오름차순으로 정렬
    sort(num.begin(), num.end());

    cout << sum << endl;
    for (int i = 0; i < num.size(); i++) {
        cout << num[i] << " ";
    }


    return 0;
}
