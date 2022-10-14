package practice2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    private String code;
    private String name;
    private LocalDate dayOfBirth;
    private String gender;

    public Person() {
    }

    public Person(String code, String name, LocalDate dayOfBirth, String gender) {
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth=" + dayOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", gender='" + gender
                ;
    }
    public abstract String getInfo();
}
