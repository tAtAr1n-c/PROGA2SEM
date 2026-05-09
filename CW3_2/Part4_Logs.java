package CW3_2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Part4_Logs {
    public static void main(String[] args) throws IOException {
        try{
            InputStream in1 = new FileInputStream("/Users/peace/IdeaProjects/Spiski/src/CW3_2/session1.log");
            InputStream in2 = new FileInputStream("/Users/peace/IdeaProjects/Spiski/src/CW3_2/session2.log");
            SequenceInputStream sis = new SequenceInputStream(in1, in2);
            InputStreamReader reader = new InputStreamReader(sis, "UTF-8");
            int b;
            while ((b = reader.read()) != -1) {
                System.out.print((char)b);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

}
