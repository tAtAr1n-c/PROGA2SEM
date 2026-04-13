package CW_Netflix;

import java.util.Objects;

public class Movie {
    int id;
    String title;
    String genry;
    int year;
    double rating;
    int duration;

    public Movie(int id, String title, String genry, int year, double rating, int duration) {
        this.id = id;
        this.title = title;
        this.genry = genry;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenry() {
        return genry;
    }

    public void setGenry(String genry) {
        this.genry = genry;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genry='" + genry + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", duration='" + duration + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
