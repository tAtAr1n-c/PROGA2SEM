package CW_Netflix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NetflixDataGenerator {

    private static final Random RANDOM = new Random();

    public static List<Movie> generateMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1, "Inception", "Sci-Fi", 2010, 8.8, 148));
        movies.add(new Movie(2, "The Matrix", "Sci-Fi", 1999, 8.7, 136));
        movies.add(new Movie(3, "Interstellar", "Sci-Fi", 2014, 8.6, 169));
        movies.add(new Movie(4, "The Dark Knight", "Action", 2008, 9.0, 152));
        movies.add(new Movie(5, "Fight Club", "Drama", 1999, 8.8, 139));
        movies.add(new Movie(6, "Pulp Fiction", "Crime", 1994, 8.9, 154));
        movies.add(new Movie(7, "Forrest Gump", "Drama", 1994, 8.8, 142));
        movies.add(new Movie(8, "The Shawshank Redemption", "Drama", 1994, 9.3, 142));
        movies.add(new Movie(9, "The Godfather", "Crime", 1972, 9.2, 175));
        movies.add(new Movie(10, "The Godfather: Part II", "Crime", 1974, 9.0, 202));
        movies.add(new Movie(11, "Avengers: Endgame", "Action", 2019, 8.4, 181));
        movies.add(new Movie(12, "Spider-Man: Into the Spider-Verse", "Animation", 2018, 8.4, 117));
        movies.add(new Movie(13, "Coco", "Animation", 2017, 8.4, 105));
        movies.add(new Movie(14, "Your Name", "Animation", 2016, 8.4, 106));
        movies.add(new Movie(15, "La La Land", "Musical", 2016, 8.0, 128));
        movies.add(new Movie(16, "The Social Network", "Drama", 2010, 7.8, 120));
        movies.add(new Movie(17, "Mad Max: Fury Road", "Action", 2015, 8.1, 120));
        movies.add(new Movie(18, "Parasite", "Thriller", 2019, 8.6, 132));
        movies.add(new Movie(19, "Whiplash", "Drama", 2014, 8.5, 106));
        movies.add(new Movie(20, "The Lion King", "Animation", 1994, 8.5, 88));

        return movies;
    }

    public static List<User> generateUsers(List<Movie> movies) {
        List<User> users = new ArrayList<>();

        users.add(new User(1, "Alice", 20, "USA", randomWatched(movies, 8, 15)));
        users.add(new User(2, "Bob", 17, "USA", randomWatched(movies, 3, 8)));
        users.add(new User(3, "Charlie", 25, "UK", randomWatched(movies, 10, 18)));
        users.add(new User(4, "Diana", 30, "Germany", randomWatched(movies, 5, 12)));
        users.add(new User(5, "Eve", 22, "France", randomWatched(movies, 7, 14)));
        users.add(new User(6, "Frank", 35, "Canada", randomWatched(movies, 2, 6)));
        users.add(new User(7, "Grace", 19, "USA", randomWatched(movies, 5, 10)));
        users.add(new User(8, "Heidi", 28, "Japan", randomWatched(movies, 10, 20)));
        users.add(new User(9, "Ivan", 23, "Russia", randomWatched(movies, 6, 12)));
        users.add(new User(10, "Judy", 40, "Brazil", randomWatched(movies, 1, 5)));

        return users;
    }

    private static List<Movie> randomWatched(List<Movie> movies, int minCount, int maxCount) {
        int count = minCount + RANDOM.nextInt(maxCount - minCount + 1);
        List<Movie> watched = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Movie movie = movies.get(RANDOM.nextInt(movies.size()));
            watched.add(movie); // допускаем повторы для моделирования «несколько просмотров»
        }
        return watched;
    }
}