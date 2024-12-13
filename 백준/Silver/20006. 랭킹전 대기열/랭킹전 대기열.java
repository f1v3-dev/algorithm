import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Room {
    private List<Player> players;
    private int minLevel;
    private int maxLevel;
    private boolean isStarted;
    private int capacity;

    public Room(int level, int capacity) {
        this.players = new ArrayList<>();
        this.minLevel = level - 10;
        this.maxLevel = level + 10;
        this.capacity = capacity;
        this.isStarted = false;
    }

    public boolean canJoin(int level) {
        return level >= minLevel && level <= maxLevel;
    }

    public void addPlayer(Player player) {
        players.add(player);
        if (players.size() == capacity) {
            isStarted = true;
        }
    }

    public boolean isFull() {
        return players.size() == capacity;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public List<Player> getPlayers() {
        Collections.sort(players);
        return players;
    }
}

class Player implements Comparable<Player> {
    private int level;
    private String name;

    public Player(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Player p) {
        return this.name.compareTo(p.name);
    }
}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int p = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            input = br.readLine().split(" ");

            int level = Integer.parseInt(input[0]);
            String name = input[1];

            Player player = new Player(level, name);
            boolean isJoin = false;

            for (Room room : rooms) {
                if (!room.isFull() && room.canJoin(level)) {
                    room.addPlayer(player);
                    isJoin = true;
                    break;
                }
            }

            if (!isJoin) {
                Room newRoom = new Room(level, r);
                newRoom.addPlayer(player);
                rooms.add(newRoom);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room.isStarted() ? "Started!" : "Waiting!").append("\n");

            for (Player player : room.getPlayers()) {
                sb.append(player.getLevel()).append(" ").append(player.getName()).append("\n");
            }
        }

        System.out.println(sb);
    }

}