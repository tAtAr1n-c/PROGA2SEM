package Practic_CW_2_2;

import java.util.List;

public class Student {
    protected String name;
    protected Integer age;
    protected String language;
    protected Double rating;
    protected List<String>  hobby;


    public Student(String name, Integer age, String language, Double rating, List<String> hobby) {
        this.name = name;
        this.age = age;
        this.language = language;
        this.rating = rating;
        this.hobby = hobby;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public List<String> getHobby() {
        return hobby;
    }
    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }


}
