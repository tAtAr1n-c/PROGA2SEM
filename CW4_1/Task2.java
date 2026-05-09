package CW4_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args){

        File output = new File("/Users/peace/IdeaProjects/Spiski/src/CW4_1/output");

        File folder = new File("/Users/peace/IdeaProjects/Spiski/src/CW4_1/input");
        File[] txtFiles = folder.listFiles(
                (dir, name) -> name.endsWith(".txt")
        );

        int aff = 0;
        int bff = 0;
        if (txtFiles != null) {
            for (File file : txtFiles) {
                if (file.isFile()) {
                    File outputFile = new File(output, file.getName());

                    FileNormalizer fn1 = new FileNormalizer(file, outputFile);
                    Thread thread = new Thread(fn1);
                    thread.start();
                }
            }
        }

        try{
            FileWriter fw = new FileWriter("/Users/peace/IdeaProjects/Spiski/src/CW4_1/result2.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Файлов обработано: " + txtFiles.length + "\n");
            bw.write("Строк до: " + bff + "\nСтрок после: " + aff);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
