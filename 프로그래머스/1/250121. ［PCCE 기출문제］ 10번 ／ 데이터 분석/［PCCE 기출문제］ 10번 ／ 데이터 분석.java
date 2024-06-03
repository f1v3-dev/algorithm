import java.util.ArrayList;
import java.util.List;

class Solution {

    static int extIndex = 0;
    static int sortIndex = 0;

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        extIndex = getIndex(ext);
        sortIndex = getIndex(sort_by);

        List<int[]> list = new ArrayList<>();

        // 1. data에서 ext 값이 val_ext보다 작은 데이터만 뽑기
        for (int[] arr : data) {
            if (arr[extIndex] < val_ext) {
                list.add(arr);
            }
        }

        // 2. sort_by에 해당하는 값을 기준으로 오름차순 정렬
        list.sort((o1, o2) -> Integer.compare(o1[sortIndex], o2[sortIndex]));

        // 3. list를 반환할 2차원 배열로 변환
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public int getIndex(String key) {
        switch (key) {
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                throw new IllegalStateException("Unexpected value: " + key);
        }
    }
}
