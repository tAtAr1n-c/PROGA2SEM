package CW3_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task3 {
    public static void main(String[] args) throws IOException {
        String path = "/Users/peace/IdeaProjects/Spiski/src/CW3_1/images.jpg";
        String path2 = "/Users/peace/IdeaProjects/Spiski/src/CW3_1/cat_copy.jpeg";

        InputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);

        OutputStream fos = new FileOutputStream(path2);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] buffer = new byte[4096];

        int bytesRead;

        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bis.close();
        bos.close();
    }
}
