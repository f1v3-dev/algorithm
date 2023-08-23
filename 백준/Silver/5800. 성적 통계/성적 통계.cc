#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() 
{
    int num;
    cin >> num;

    for (int i = 0; i < num; i++) {
        int student_count;
        cin >> student_count;
        int gap = -1;

        vector<int> v;
        for (int j = 0; j < student_count; j++) {
            int score;
            cin >> score;
            v.push_back(score);
        }

        // 내림차순 정렬
        sort(v.begin(), v.end(), greater<>());
        int max = v.front();
        int min = v.back();

        for (int j = 0; j < student_count - 1; j++) {
            if (gap < v[j] - v[j + 1]) {
                gap = v[j] - v[j + 1];
            }
        }
        cout << "Class " << i + 1 << endl;
        cout << "Max " << max << ", Min " << min << ", Largest gap " << gap << endl;

    }
    return 0;
}
