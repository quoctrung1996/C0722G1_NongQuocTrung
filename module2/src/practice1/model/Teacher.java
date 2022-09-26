package practice1.model;

import java.time.LocalDate;

public class Teacher extends Person {
    private String major;

    public Teacher() {
    }

    public Teacher(String code, String name, LocalDate birthday, String gender, String major) {
        super(code, name, birthday, gender);
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
        return "Teacher{" + super.toString() +
                "major='" + major + '\'' +
                '}';
    }
}
