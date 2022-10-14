package practice2.util;

import practice2.model.Student;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WriteFileAndReadFile {
    private static final String FILE = "src/practice2/data/student.csv";

    public static List<Student> readFile() {
        List<Student> studentList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            Student student;
            String[] info;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                student = new Student(info[0], info[1], LocalDate.parse(info[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")), info[3], info[4], Double.parseDouble(info[5]));
                studentList.add(student);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
    public static void writeFile(List<Student> studentList){
        try {
            FileWriter fileWriter=new FileWriter(FILE);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Student student:studentList){
                bufferedWriter.write(student.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
