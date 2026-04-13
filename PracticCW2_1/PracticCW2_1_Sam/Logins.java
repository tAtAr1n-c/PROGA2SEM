package PracticCW2_1.PracticCW2_1_Sam;

import java.util.ArrayList;
public class Logins {
    public static void main(String[] args){
        ArrayList<String> login = new ArrayList<>();
        login.add("Av1nr");
        login.add("TaTaR1n");
        login.add("kam");
        login.add("jo");
        login.add("5eleba");
        login.removeIf(name -> name.length() < 4);
        System.out.println(login);

    }
}
