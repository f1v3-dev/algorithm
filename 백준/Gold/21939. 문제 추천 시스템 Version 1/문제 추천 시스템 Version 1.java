import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

class Problem {
    private int P;
    private int L;

    public Problem(int P, int L) {
        this.P = P;
        this.L = L;
    }

    public int getP() {
        return P;
    }

    public int getL() {
        return L;
    }
}

public class Main implements Comparator<Problem> {

    @Override
    public int compare(Problem o1, Problem o2) {
        if (o1.getL() < o2.getL()) return -1;
        else if (o1.getL() == o2.getL()) {
            return Integer.compare(o1.getP(), o2.getP()); // 문제 번호가 작은 순서로
        } else return 1;
    }

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hm = new HashMap<>();
        TreeSet<Problem> ts = new TreeSet<>(new Main());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int P = Integer.parseInt(str[0]);
            int L = Integer.parseInt(str[1]);

            ts.add(new Problem(P, L));
            hm.put(P, L);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");

            switch (str[0]) {
                case "recommend":
                    if (str[1].equals("1")) {
                        sb.append(ts.last().getP()).append("\n");
                    } else {
                        sb.append(ts.first().getP()).append("\n");
                    }
                    break;

                case "add":
                    int addProblem = Integer.parseInt(str[1]);
                    int addLevel = Integer.parseInt(str[2]);

                    ts.add(new Problem(addProblem, addLevel));
                    hm.put(addProblem, addLevel);
                    break;

                case "solved":
                    int solvedProblem = Integer.parseInt(str[1]);
                    int solvedLevel = hm.get(solvedProblem);

                    ts.remove(new Problem(solvedProblem, solvedLevel));
                    hm.remove(solvedProblem);
                    break;
            }
        }
        System.out.println(sb);
    }
}
