package CW_Netflix;

import Practic_CW_2_2_2.Order;

import java.util.*;
import java.util.stream.Collectors;

public class NetflixApp {

    public static void main(String[] args) {
        List<Movie> movies = NetflixDataGenerator.generateMovies();
        List<User> users = NetflixDataGenerator.generateUsers(movies);

        // Здесь вы пишете свои решения:
        // tasksA(users, movies); tasksB(...); и т.д.

        Set<Movie> task1_1 = users.stream().
                flatMap(user -> user.movies.stream()).
                collect(Collectors.toSet());
        task1_1.stream().
                map(Movie::getTitle).
                sorted().
                forEach(System.out::println);

        task1_1.stream().
                filter(movie -> movie.getRating() >= 8).
                sorted((m1, m2) -> {
                    int ratingCompare = Double.compare(m2.getRating(), m1.getRating());
                    if (ratingCompare != 0) return ratingCompare;
                    return m1.getTitle().compareTo(m2.getTitle());
                }).forEach(System.out::println);

        Set<User> task1_3 = users.stream()
                        .filter(user -> user.getAge() >= 18 && !user.movies.isEmpty())
                .collect(Collectors.toSet());

        task1_3.stream().forEach(System.out::println);

        List<Movie> task1_4 = users.stream().
                flatMap(user -> user.movies.stream()).
                toList();
        System.out.println(task1_4.size());


        //Часть 3
        Map<String, List<Movie>> task3_1= task1_1.stream().collect(Collectors.groupingBy(Movie::getGenry));
        System.out.println(task3_1);

        Map<String, Long> t3_2 = users.stream().
                flatMap(user -> user.movies.stream())
                .collect(Collectors.groupingBy(Movie::getGenry, Collectors.counting()));

        Map<User, Long> t3_3 = users.stream().
                collect(Collectors.toMap(
                        user -> user,
                        user -> (long) user.movies.size()
                ));
        System.out.println(t3_3);

        Map<User, Integer> t3_4 = users.stream().
                collect(Collectors.toMap(
                        user -> user,
                        User::maxDuration
                ));

        //Часть 4
        Map<String, Long>  t4_1 = users.stream().
                filter(user -> user.getAge() >= 18 && user.getAge() <= 25).
                flatMap(user -> user.movies.stream()).
                map(Movie::getGenry).
                collect(Collectors.groupingBy(genres -> genres, Collectors.counting()));
        Long max = getMaxMap(t4_1);
        for (String genreName : t4_1.keySet()) {
            if (t4_1.get(genreName).equals(max)) {
                System.out.println(genreName);
            }
        }


        Map<Movie, Long> t4_2_1 = users.stream().
                flatMap(user -> user.movies.stream()).
                collect(Collectors.groupingBy(genres -> genres, Collectors.counting()));

        List<Long> t4_2= t4_2_1.values().stream().sorted(Comparator.reverseOrder()).limit(3).toList();

        int count = 1;
        for (Movie movie : t4_2_1.keySet()) {
            Long watched = t4_2_1.get(movie);
            if (t4_2.contains(watched) && count <= 3) {
                System.out.print(count + ". ");
                System.out.println(movie);
                count++;
            }
        }

        Map<String, Double> task4_3 = users.stream().
                collect(Collectors.groupingBy(User::getCountry, Collectors.averagingDouble(User::averageRating)));
        System.out.println(task4_3);

        Map<Movie, Long> t4_4_1= users.stream().
                flatMap(user -> user.movies.stream()).
                collect(Collectors.groupingBy(genres -> genres, Collectors.counting()));


        List<Long> t4_4= t4_4_1.values().stream().filter(user -> user >= 5).sorted(Comparator.reverseOrder()).toList();
        int count2 = 0;
        for (Movie movie : t4_2_1.keySet()) {
            Long watched = t4_2_1.get(movie);
            if (t4_2.contains(watched)) {
                System.out.print(count2 + ". ");
                System.out.println(movie);
                count2++;
            }
        }

        System.out.println("Movies: " + movies.size());
        System.out.println("Users: " + users.size());
    }


    public static Long getMaxMap(Map<String, Long> map){
        return Collections.max(map.values());
    }
}