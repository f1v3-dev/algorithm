# 최소공배수

### [문제]

두 수의 최소공배수를 구해보세요.

### [조건]

유클리드 호제법을 이용해보세요.
```
A >= B 인 어떤 두 정수 A, B(A = Bq + r)가 있을 때,
A와 B의 최대공약수 gcd(A, B) = d는 gcd(B, r)과 같다.

A, B의 최대공약수를 G, 최소공배수를 L이라고 할 때,
A = Ga, B = Gb (a, b는 서로소)
L = Gab = AB/G
```

**[예시]**

|   입력   | -> |  출력  |
|:------:|----|:----:|
|  1, 1  |    |  1   |
| 98, 49 |    | 4606 |
| 2, 81  |    | 162  |
|  3, 7  |    |  21  |
| 19, 87 |    | 1653 |
| 1, 40  |    |  40  |