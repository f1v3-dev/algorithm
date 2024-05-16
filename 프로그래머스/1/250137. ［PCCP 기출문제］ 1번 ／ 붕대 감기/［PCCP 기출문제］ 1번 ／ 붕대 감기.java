class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량
        int currentHealth = health;

        // 마지막 공격 시간
        int lastAttackTime = attacks[attacks.length - 1][0];

        // 연속 성공을 저장할 변수 선언
        int recoveryCount = 0;

        int attackIndex = 0;
        for (int i = 1; i <= lastAttackTime; i++) {
            int time = attacks[attackIndex][0];
            int damage = attacks[attackIndex][1];

            // 몬스터의 공격 시간인 경우
            if (time == i) {
                attackIndex++;
                currentHealth -= damage;

                // 현재 체력이 0 이하인 경우 -1 반환
                if (currentHealth <= 0) {
                    return -1;
                }
                // 공격을 당했을 경우 recoveryCount 초기화
                recoveryCount = 0;
            } else {

                // 현재의 체력이 최대 체력보다 낮을 경우
                recoveryCount++;
                if (currentHealth < health) {

                    currentHealth += x;
                    if (recoveryCount == t) {
                        currentHealth += y;
                        recoveryCount = 0;
                    }

                    // 최대 체력을 넘어간 경우 최대 체력으로 설정
                    if (currentHealth > health) {
                        currentHealth = health;
                    }
                }
            }
        }

        return currentHealth;
    }
}