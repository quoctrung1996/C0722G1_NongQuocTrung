package ss5_access_modifier.exercise.student;

public class Student {
    private String name = "John";
    private String classes = "C02";

    Student() {
    }

    public void setName(String name) {
        this.name = name;
    }
//    protected void setName(String name) {
//        this.name = name;
//    }
//    void setName(String name) {
//        this.name = name;
//    }
//    private void setName(String name) {
//        this.name = name;
//    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

//    protected void setClasses(String classes) {
//        this.classes = classes;
//    }
//
//    void setClasses(String classes) {
//        this.classes = classes;
//    }
//
//    private void setClasses(String classes) {
//        this.classes = classes;
//    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}
