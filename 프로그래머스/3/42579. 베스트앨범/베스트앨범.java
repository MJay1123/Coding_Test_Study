import java.util.*;
class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Genre> list = new ArrayList<>();
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            Genre g = null;
            for(int j=0; j<list.size(); j++){
                if(list.get(j).genre.equals(genre)){
                    g = list.get(j);
                    break;
                }
            }
            if(g == null){
                g = new Genre(genre);
                list.add(g);
            }
            g.add(new Song(i, play));
        }
        Collections.sort(list);
        List<Integer> answer = new ArrayList<>();
        for(Genre g : list){
            for(int i=0; i<2; i++){
                if(!g.songs.isEmpty()){
                    answer.add(g.songs.poll().number);
                }
            }
        }
        return answer;
    }
    class Genre implements Comparable<Genre>{
        String genre;
        int totalPlay;
        PriorityQueue<Song> songs;
        public Genre(String genre){
            this.genre = genre;
            this.totalPlay = 0;
            this.songs = new PriorityQueue<>();
        }
        void add(Song song){
            this.songs.offer(song);
            this.totalPlay += song.play;
        }
        @Override
        public int compareTo(Genre g){
            return g.totalPlay - this.totalPlay;
        }
        @Override
        public String toString(){
            return "Genre[" + genre + ", " + totalPlay + ", " + songs + "]";
        }
    }
    class Song implements Comparable<Song>{
        int number;
        int play;
        public Song(int number, int play){
            this.number = number;
            this.play = play;
        }
        @Override
        public int compareTo(Song s){
            return s.play - this.play;
        }
        @Override
        public String toString(){
            return "Song [" + number + ", " + play + "]";
        }
    }
}