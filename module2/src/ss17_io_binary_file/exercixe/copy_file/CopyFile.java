package ss17_io_binary_file.exercixe.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        try {
            File file = new File("src/ss17_io_binary_file/data/source_file.dat");
            if (!file.exists()) {
                throw new FileNotFoundException("tệp nguồn không tồn tại");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject("hello");
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/ss17_io_binary_file/data/target_file.dat");
            FileInputStream fileInputStream = new FileInputStream("src/ss17_io_binary_file/data/source_file.dat");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


            String string=(String)objectInputStream.readObject();
            objectOutputStream.writeObject(string);

            long size = fileOutputStream.getChannel().size();
            System.out.println("The file size is " + size + " bytes");

            objectInputStream.close();
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }




    }
}