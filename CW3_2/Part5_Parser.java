package CW3_2;

import java.io.FileReader;
import java.io.PushbackReader;

public class Part5_Parser {
    public static void main(String[] args) {
        int count = 0;

        System.out.println("КОМАНДЫ К ВЫПОЛНЕНИЮ");

        try (PushbackReader pr = new PushbackReader(
                new FileReader("/Users/peace/IdeaProjects/Spiski/src/CW3_2/commands.txt"))) {

            int ch;

            while ((ch = pr.read()) != -1) {
                if (ch == '#') {
                    while ((ch = pr.read()) != -1 && ch != '\n') {
                    }
                }else {
                    pr.unread(ch);
                    String command = "";
                    while ((ch = pr.read()) != -1 && ch != '\n') {
                            command = command + (char) ch;
                    }
                    System.out.println("Команда: " + command);
                    count++;
                }
            }
            System.out.println("Итого команд: " + count);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
