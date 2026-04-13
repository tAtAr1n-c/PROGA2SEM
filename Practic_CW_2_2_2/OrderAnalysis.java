package Practic_CW_2_2_2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OrderAnalysis {
    public static void main(String[] args) {
        Product product1 = new Product(101, "Ноутбук");
        Product product2 = new Product(102, "Мышка");
        Product product3 = new Product(103, "Клавиатура");
        Product product4 = new Product(104, "Наушники");
        Product product5 = new Product(105, "Монитор");

        User user1 = new User(1, "Аня");
        User user2 = new User(2, "Иван");
        User user3 = new User(3, "Борис");

        List<Product> allProducts = new ArrayList<>();
        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);
        allProducts.add(product4);
        allProducts.add(product5);

        List<User> allUsers = new ArrayList<>();
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);

        Order order1 = new Order(5001, List.of(product1, product2), user1);
        Order order2 = new Order(5002, List.of(product3, product4, product2), user2);
        Order order3 = new Order(5003,  List.of(product5), user3);
        Order order4 = new Order(5004,  List.of(product4, product5), user1);

        List<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);
        allOrders.add(order3);
        allOrders.add(order4);


        List<Product> t1 = allOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .toList();
        System.out.println(t1);
        System.out.println();


        Map<String, Long> t2 = allOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
        System.out.println(t2);
        System.out.println();


        Map<Product, List<User>> usersByProduct = allProducts.stream()
                .collect(Collectors.toMap(
                        product -> product,
                        product -> allOrders.stream()
                                .filter(order -> order.getProducts().contains(product))
                                .map(Order::getUser)
                                .distinct()
                                .collect(Collectors.toList())
                ));
        System.out.println("\n=== Задача 3: Какие пользователи заказывали каждый товар ===");
        usersByProduct.forEach((product, users) -> {
            String userNames = users.stream()
                    .map(User::getName)
                    .collect(Collectors.joining(", "));
            System.out.println(product.getName() + " -> " + userNames);
        });
        System.out.println();

        Optional<Order> t4 = allOrders.stream()
                .max(Comparator.comparingInt(order -> order.getProducts().size()));
        System.out.println(t4);
        System.out.println();

        Map<User, Long> t5 = allOrders.stream()
                .collect(Collectors.groupingBy(Order::getUser, Collectors.counting()));

        System.out.println(t5);
        System.out.println();
    }
}
