package ss6_inheritence.domo;

public class Main {
    public static void main(String[] args) {
        Cha contrai=new Contrai();
        Cha con=new Con();
        Con con1=new Con();
        Cha cha=new Cha();
//
        System.out.println(con.toString());
//        con.m2()   đang khai báo theo kiểu cha nên k truy cập được


        //Kiểu ép kiểu
        //upcasting:
        Cha c =new Contrai();

        //duyệt 1 mảng thuộc lớp cha
        Cha[] chaList=new Cha[3];
        chaList[0]=new Con();
        chaList[1]=new Contrai();
        chaList[2]=new Contrai();
        int s=0;
        for (int i = 0; i < 3; i++) {
            s+=chaList[i].tinhTien();
        }
        System.out.println(s);

        //Không thể
      //  chaList[0].m2();
        // ép từ kiêu cha xuống kiểu con để thực hiện các phương thức
        //(<kiểu dữ liệu thuộc lớp con>) tên biến
        //downcasting
        ((Con)chaList[0]).m2();
        con1.m2();
    }
}
