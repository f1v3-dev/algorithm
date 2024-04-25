import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MedalComparator implements Comparator<Country> {

    @Override
    public int compare(Country o1, Country o2) {
        if (o1.getGold() != o2.getGold())
            return Integer.compare(o2.getGold(), o1.getGold());
        else if (o1.getSilver() != o2.getSilver())
            return Integer.compare(o2.getSilver(), o1.getSilver());
        else
            return Integer.compare(o2.getBronze(), o1.getBronze());
    }
}

class Country {
    private final int id;
    private final int gold;
    private final int silver;
    private final int bronze;
    private int rank;

    public Country(int id, int gold, int silver, int bronze) {
        this.id = id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rank = 1;
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }

    public int getBronze() {
        return bronze;
    }

    public int getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

public class Main {

    static List<Country> countries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            createCountry(input);
        }

        Collections.sort(countries, new MedalComparator());

        // 공동 순위가 존재할 수 있음
        for (int i = 1; i < n; i++) {
            Country prev = countries.get(i - 1);
            Country current = countries.get(i);

            if (prev.getGold() == current.getGold()
                    && prev.getSilver() == current.getSilver()
                    && prev.getBronze() == current.getBronze()) {
                current.setRank(prev.getRank());
            } else {
                current.setRank(i + 1);
            }
        }

        countries.stream()
                .filter(country -> country.getId() == k)
                .map(country -> country.getRank())
                .limit(1)
                .forEach(System.out::println);

    }

    private static void createCountry(String[] input) {
        int id = Integer.parseInt(input[0]);
        int gold = Integer.parseInt(input[1]);
        int silver = Integer.parseInt(input[2]);
        int bronze = Integer.parseInt(input[3]);

        Country country = new Country(id, gold, silver, bronze);
        countries.add(country);
    }
}
