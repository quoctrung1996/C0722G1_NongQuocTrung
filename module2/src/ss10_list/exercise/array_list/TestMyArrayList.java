package ss10_list.exercise.array_list;

public class TestMyArrayList {
    public static class Student {
        private int id;
        public String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1, "trung");
        Student b = new Student(2, "huy");
        Student c = new Student(3, "hai");
        Student d = new Student(4, "ba");
        Student e = new Student(5, "bon");
        Student f = new Student(5, "bon2");
        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);
        //studentMyArrayList.clear();
        System.out.println(studentMyArrayList.size());

        for (int i = 0; i < studentMyArrayList.size(); i++) {
            Student student = (Student) studentMyArrayList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }
        System.out.println(studentMyArrayList.get(2).getName());
    }
}
