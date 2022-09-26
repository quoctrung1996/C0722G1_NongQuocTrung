package practice1.model;

import java.time.LocalDate;

public abstract class Person {
    private String code;
    private String name;
    private LocalDate birthday;
    private String gender;

    public Person() {
    }

    public Person(String code, String name, LocalDate birthday, String gender) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "code='" + code + '\'' +
                "name='" + name + '\n' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
