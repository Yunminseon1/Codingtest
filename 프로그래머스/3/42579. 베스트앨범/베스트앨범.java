import java.util.*;

class Solution {

    class Song {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        // 1. 장르별 총 재생 수
        HashMap<String, Integer> totalMap = new HashMap<>();

        // 2. 장르별 노래 목록
        HashMap<String, List<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            totalMap.put(g, totalMap.getOrDefault(g, 0) + p);

            songMap.putIfAbsent(g, new ArrayList<>());
            songMap.get(g).add(new Song(i, p));
        }

        // 3. 장르 정렬 (총 재생 수 내림차순)
        List<String> genreList = new ArrayList<>(totalMap.keySet());
        genreList.sort((a, b) -> totalMap.get(b) - totalMap.get(a));

        List<Integer> result = new ArrayList<>();

        // 4. 각 장르에서 상위 2곡 선택
        for (String genre : genreList) {
            List<Song> list = songMap.get(genre);

            list.sort((a, b) -> {
                if (b.play == a.play) {
                    return a.index - b.index;
                }
                return b.play - a.play;
            });

            result.add(list.get(0).index);
            if (list.size() > 1) {
                result.add(list.get(1).index);
            }
        }

        // 5. List → int[]
        return result.stream().mapToInt(i -> i).toArray();
    }
}