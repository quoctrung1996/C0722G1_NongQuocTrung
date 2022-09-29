package practice1.model;

import java.time.LocalDate;

public abstract class Person {
    private Integer code;
    private String name;
    private String birthday;
    private String gender;

    public Person() {
    }

    public Person(Integer code, String name, String birthday, String gender) {
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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
    public String getInfo(){
        return String.format("%s,%s,%s,%s,",this.code,this.name,this.birthday,this.gender);
    }
}
