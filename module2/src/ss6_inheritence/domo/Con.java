package ss6_inheritence.domo;

public class Con extends Cha {
    public String sex;

    public Con() {
        //vãn được gọi nhưng mà nó ẩn đi
        //vẫn gọi cónstructor không tham số của lớp cha
       // super("trung","á");
        super();
        System.out.println("hàm khởi tạo con");
    }

    public Con(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public void m2(){
        super.getName();
    }
    @Override
    //ghi đè
    public void m1(){
        System.out.println("pt thuộc lớp con");
    }

    @Override
    public String toString() {
        return "Con{" +
                "name"+this.getName()+
                "sex='" + sex + '\'' +
                '}';
    }
}
