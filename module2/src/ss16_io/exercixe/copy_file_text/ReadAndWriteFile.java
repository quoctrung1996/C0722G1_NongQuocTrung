package ss16_io.exercixe.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static String readFIle(String filePath) {
        File file = new File(filePath);
        String line="";
        try {
            if (!file.exists()) {
                throw new IOException("File không tồn tại");
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s="";
            while ((s=bufferedReader.readLine())!=null){
                line+=s;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return line;
    }

    public static void writeFile(String filePath, String line) {
        List<Character> characters=new ArrayList<>();
        File file=new File(filePath);
        try {
            if (file.exists()){
               throw new IOException("File đã tồn tại");
            }
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            for (int i = 0; i < line.split("").length; i++) {
                if ((line.charAt(i))!=' ') {
                    characters.add(line.charAt(i));
                }
            }
            bufferedWriter.write("số kí tự là: "+characters.size());
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        ReadAndWriteFile.readFIle("src/ss16_io/data/source_file.csv");
        ReadAndWriteFile.writeFile("src/ss16_io/data/target_file.csv",ReadAndWriteFile.readFIle("src/ss16_io/data/source_file.csv"));
    }
}
