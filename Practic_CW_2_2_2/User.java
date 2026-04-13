package Practic_CW_2_2_2;

public class User {
    int id;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    String name;

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
}
