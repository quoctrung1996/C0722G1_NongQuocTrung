package practice1.model;

import java.time.LocalDate;

public class Student extends Person {
    private String className;
    private double score;

    public Student() {
    }

    public Student(Integer code, String name, String birthday, String gender, String className, double score) {
        super(code, name, birthday, gender);
        this.className = className;
        this.score = score;
    }



    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "className='" + className + '\'' +
                ", score=" + score +
                '}';
    }
    public String getInfo(){
        return super.getInfo()+String.format("%s,%s",this.className,this.score);
    }
}
