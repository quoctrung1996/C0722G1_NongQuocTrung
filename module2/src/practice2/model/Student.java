package practice2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student extends Person{
    private String nameClass;
    private double score;

    public Student() {
    }

    public Student(String code, String name, LocalDate dayOfBirth, String gender, String nameClass, double score) {
        super(code, name, dayOfBirth, gender);
        this.nameClass = nameClass;
        this.score = score;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +super.toString()+
                ", nameClass='" + nameClass + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s",getCode(),getName(),getDayOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),getGender(),getNameClass(),getScore());
    }
}
