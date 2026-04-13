package Practic_CW_2_2_2;

import java.util.List;

public class Order {
    int id;
    User user;
    List<Product> products;

    public Order(int id, List<Product> products, User user) {
        this.id = id;
        this.products = products;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
