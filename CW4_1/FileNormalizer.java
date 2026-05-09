package CW4_1;

import java.io.*;

public class FileNormalizer implements Runnable {

    File inputFile;
    File outputFile;
    public int before;
    public int after;

    public FileNormalizer(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public void run(){
        try {
            FileInputStream fis = new FileInputStream(inputFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);

            String line;
            int aff = 0;
            int bff = 0;
            while ((line = br.readLine()) != null) {
                bff++;
                if(line.isBlank()){
                    continue;
                }else{
                    line = line.strip().toLowerCase();
                    bw.newLine();
                }
                bw.write(line);
                aff++;
            }
            br.close();
            bw.close();
            after = aff;
            before = bff;
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

    }
}
