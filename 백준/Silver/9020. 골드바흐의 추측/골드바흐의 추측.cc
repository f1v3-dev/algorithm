#include <iostream>
#include <cmath>
using namespace std;

bool primeNum[10002];
void primeNumberSieve(int number)
{

    for (int i = number / 2; i < number; i++) {
        if (primeNum[i] && primeNum[number - i]) {
            cout << number - i << ' ' << i << endl;
            break;
        }
    }
}
int main()
{
    // primeNum에 값 초기화
    primeNum[1] = false;
    for (int i = 2; i <= 10000; i++) {
        primeNum[i] = true;
    }


    // 에라토스테네스의 체 적용
    for (int i = 2; i <= sqrt(10000); i++) {
        if (primeNum[i] == false) {
            continue;
        }

        for (int j = i + i; j <= 10000; j += i) {
            primeNum[j] = false;
        }
    }

    int T;
    cin >> T;
    while (T--) {
        int input;
        cin >> input;
        primeNumberSieve(input);
    }

    return 0;
}