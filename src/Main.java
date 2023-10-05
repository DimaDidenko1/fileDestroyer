import java.io.*;
import java.security.SecureRandom;
import java.util.Random;
import java.util.RandomAccess;

public class Main {
    public static void main(String[] args) {
        String path = "src/text.txt";
        File file = new File(path);
        if(file.exists()){
            try{
                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                raf.setLength(0);
                SecureRandom random = new SecureRandom();
                byte[] buffer = new byte[1024];


                    while (raf.getFilePointer() < raf.length()) {
                        random.nextBytes(buffer);
                        raf.write(buffer);
                    }
                    raf.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {
            System.out.println("Файл не існує.");
        }
    }
}