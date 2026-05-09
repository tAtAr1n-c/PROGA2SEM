package CW3_1;

import java.io.*;

public class Task4 {
    static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/peace/IdeaProjects/Spiski/src/CW3_1/task4_clone.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        String path = "/Users/peace/IdeaProjects/Spiski/src/CW3_1/task_4_win.txt";
        InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "UTF-8");
        int ch;
        while ((ch = reader.read()) != -1) {
            bos.write(ch);
        }
        bos.close();
        fos.close();
        reader.close();

    }
}