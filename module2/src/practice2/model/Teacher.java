package practice2.model;

import java.time.LocalDate;

public class Teacher extends Person{
    private String major;

    public Teacher() {
    }

    public Teacher(String code, String name, LocalDate dayOfBirth, String gender, String major) {
        super(code, name, dayOfBirth, gender);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "major='" + major + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s",getCode(),getName(),getDayOfBirth(),getGender(),getMajor());
    }
}
