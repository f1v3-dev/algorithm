import java.util.*;

class Song {
    public String genre;
    public Integer plays;
    public Integer pivot;

    public Song(String genre, Integer plays, Integer pivot) {
        this.genre = genre;
        this.plays = plays;
        this.pivot = pivot;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            Song song = new Song(genres[i], plays[i], i);
            songs.add(song);

            genreTotalPlays.put(genres[i], genreTotalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        Collections.sort(sortedGenres, (a, b) -> (genreTotalPlays.get(b) - genreTotalPlays.get(a)));

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            
            List<Song> genreSongs = new ArrayList<>();
            
            for (Song song : songs) {
                if (song.genre.equals(genre)) {
                    genreSongs.add(song);
                }
            }
            
            Collections.sort(genreSongs, (a, b) -> {
                if (a.plays.equals(b.plays)) {
                    return a.pivot - b.pivot;
                }
                return b.plays - a.plays;
            });

            int count = 0;
            for (Song song : genreSongs) {
                if (count >= 2) {
                    break;
                }
                result.add(song.pivot);
                count++;
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
