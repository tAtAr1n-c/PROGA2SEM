package CW_Netflix;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class User {
    int id;
    String name;
    int age;
    String country;
    List<Movie> movies;

    public User(int id, String name, int age, String country, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Double averageRating() {
        if(!movies.isEmpty()){Double rating = 0.0;
            for (Movie movie : movies) {
                rating += movie.rating;
            }
            return rating / movies.size();}
        return 0.0;

    }

    public Integer maxDuration() {
        if(!movies.isEmpty()) {
            return movies.stream().min(Comparator.comparing(Movie::getDuration)).get().getDuration();
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", country='" + country + '\'' +
                ", movies=" + movies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
