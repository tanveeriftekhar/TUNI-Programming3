package fi.tuni.prog3.streams;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MovieAnalytics{
    // private List<Movie> movies;

    // public MovieAnalytics(List<Movie> movies) {
    //     movies = new ArrayList<>();
    //     this.movies = movies;
    // }

    private List<Movie> movies = new ArrayList<>();

    public MovieAnalytics() {
    }

    public static Consumer<Movie> showInfo() {
        return movie -> System.out.println(movie.getTitle() + " (By " + movie.getDirector() + ", " + movie.getReleaseYear() + ")");
    }

   
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
                    movies.add(new Movie(title, releaseYear, duration, genre, score, director));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stream<Movie> moviesAfter(int year) {
        return movies.stream()
                .filter(movie -> movie.getReleaseYear() >= year)
                .sorted((m1, m2) -> {
                    if (m1.getReleaseYear() != m2.getReleaseYear()) {
                        return m1.getReleaseYear() - m2.getReleaseYear();
                    }
                    return m1.getTitle().compareTo(m2.getTitle());
                });
    }

    public Stream<Movie> moviesBefore(int year) {
        return movies.stream()
                    .filter(movie -> movie.getReleaseYear() <= year)
                    .sorted((m1, m2) -> {
                        if (m1.getReleaseYear() != m2.getReleaseYear()) {
                            return m1.getReleaseYear() - m2.getReleaseYear();
                        }
                        return m1.getTitle().compareTo(m2.getTitle());
                    });
    }

    public Stream<Movie> moviesBetween(int yearA, int yearB) {
        return movies.stream()
                    .filter(movie -> movie.getReleaseYear() >= yearA && movie.getReleaseYear() <= yearB)
                    .sorted((m1, m2) -> {
                        if (m1.getReleaseYear() != m2.getReleaseYear()) {
                            return m1.getReleaseYear() - m2.getReleaseYear();
                        }
                        return m1.getTitle().compareTo(m2.getTitle());
                    });
    }

    public Stream<Movie> moviesByDirector(String director) {
        return movies.stream()
                .filter(movie -> movie.getDirector().equals(director))
                .sorted((m1, m2) -> {
                    if (m1.getReleaseYear() != m2.getReleaseYear()) {
                        return m1.getReleaseYear() - m2.getReleaseYear();
                    }
                    return m1.getTitle().compareTo(m2.getTitle());
                });
    }
    
}
