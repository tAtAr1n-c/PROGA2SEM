package PracticCW2_1.PracticCW2_1_Vmes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("Красный"), new Car("Синий")));
        List<Car> redCars = filter(cars, new CarFilter() {
            @Override
            public boolean filter(Car car) {
                return car.getColor().equals("Красный");
            }
        });

    }
    public static List<Car> filter(List<Car> cars, CarFilter filter) {
        return new ArrayList<>();
    }

}
