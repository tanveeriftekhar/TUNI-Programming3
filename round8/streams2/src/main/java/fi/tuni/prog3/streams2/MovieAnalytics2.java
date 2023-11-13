package fi.tuni.prog3.streams2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieAnalytics2{
    // private List<Movie> movies;

    // public MovieAnalytics(List<Movie> movies) {
    //     movies = new ArrayList<>();
    //     this.movies = movies;
    // }

    private List<Movie> movieList;

    public MovieAnalytics2() {
        movieList = new ArrayList<>();
    }

//     public static Consumer<Movie> showInfo() {
//         return movie -> System.out.println(movie.getTitle() + " (By " + movie.getDirector() + ", " + movie.getReleaseYear() + ")");
//     }

   
public void populateWithData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    String title = parts[0];
                    int releaseYear = Integer.parseInt(parts[1]);
                    int duration = Integer.parseInt(parts[2]);
                    String genre = parts[3];
                    double score = Double.parseDouble(parts[4]);
                    String director = parts[5];
                    
                    // Create a Movie object and add it to the movies list
                    movieList.add(new Movie(title, releaseYear, duration, genre, score, director));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printCountByDirector(int n) {
        Map<String, Long> directorCounts = movieList.stream()
                .collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting()));

        directorCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " movies"));
    }

    public void printAverageDurationByGenre() {
        Map<String, Double> genreAvgDurations = movieList.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.averagingInt(Movie::getDuration)));

        genreAvgDurations.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + String.format("%.2f", entry.getValue())));
    }

    public void printAverageScoreByGenre() {
        Map<String, Double> genreAvgScores = movieList.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.averagingDouble(Movie::getScore)));

        genreAvgScores.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + String.format("%.2f", entry.getValue())));
    }
    
}
