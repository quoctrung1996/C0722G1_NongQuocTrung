package furama_resort.service.impl;

import furama_resort.model.Facility;
import furama_resort.model.House;
import furama_resort.model.Room;
import furama_resort.model.Villa;
import furama_resort.service.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    Scanner sc = new Scanner(System.in);
    Map<Facility, Integer> map = new LinkedHashMap<>();

    @Override
    public void displayFacility() {
        for(Map.Entry<Facility,Integer> display:map.entrySet()){
            System.out.println(display.getKey().toString());
        }

    }

    @Override
    public void add() {
        System.out.println("1.Add New Villa");
        System.out.println("2.Add New House");
        System.out.println("3.Add New Room");
        System.out.println("4.Back to menu");
        System.out.println("Mời chọn:");
        int choise = Integer.parseInt(sc.nextLine());
        switch (choise) {
            case 1:
                Villa villa = this.infoVilla();
                map.put(villa, 0);
                System.out.println("Thêm thành công");
                break;
            case 2:
                House house = this.infoHouse();
                map.put(house, 0);
                System.out.println("Thêm thành công");
                break;
            case 3:
                Room room=this.infoRoom();
                map.put(room,0);
                System.out.println("Thêm thành công");
                break;
            case 4:
                return;
            default:
                System.out.println("Không có lựa chọn nào phù hợp");
        }
    }

    @Override
    public void displayFacilityMaintenance() {

    }

    public Villa infoVilla() {
        System.out.println("Nhập tên dịch vụ");
        String serviceName = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng");
        double areaUse = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập chi phí thuê");
        double rentaClosts = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập số lượng người tối đa");
        int people = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê");
        String rentalType = sc.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng");
        String roomStandard = sc.nextLine();
        System.out.println("Nhập diện tích hồ bơi");
        double poolArea = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập số tầng");
        int numberFloors = Integer.parseInt(sc.nextLine());
        Villa villa = new Villa(serviceName, areaUse, rentaClosts, people, rentalType, roomStandard, poolArea, numberFloors);
        return villa;
    }

    public House infoHouse() {
        System.out.println("Nhập tên dịch vụ");
        String serviceName = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng");
        double areaUse = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập chi phí thuê");
        double rentaClosts = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập số lượng người tối đa");
        int people = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê");
        String rentalType = sc.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng");
        String roomStandard = sc.nextLine();
        System.out.println("Nhập số tầng");
        int numberFloors = Integer.parseInt(sc.nextLine());
        House house = new House(serviceName, areaUse, rentaClosts, people, rentalType, roomStandard, numberFloors);
        return house;
    }
    public Room infoRoom(){
        System.out.println("Nhập tên dịch vụ");
        String serviceName = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng");
        double areaUse = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập chi phí thuê");
        double rentaClosts = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập số lượng người tối đa");
        int people = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê");
        String rentalType = sc.nextLine();
        System.out.println("Nhâp dịch vụ miễn phí đi kèm");
        String freeService=sc.nextLine();
        Room room=new Room(serviceName, areaUse, rentaClosts, people, rentalType,freeService);
        return room;
    }
}
