package furama_resort.service.impl;

import furama_resort.model.Facility;
import furama_resort.model.House;
import furama_resort.model.Room;
import furama_resort.model.Villa;
import furama_resort.service.IFacilityService;
import furama_resort.utils.checks.Check;
import furama_resort.utils.checks.CheckException;
import furama_resort.utils.checks.CheckRegexFacility;
import furama_resort.utils.write_and_read.ReadFile;
import furama_resort.utils.write_and_read.WriteFile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    private static final String REGEX_FILE = "src/furama_resort/data/facility.csv";
    CheckRegexFacility checkRegex = new CheckRegexFacility();
    CheckException checkException = new CheckException();
    Scanner sc = new Scanner(System.in);
    Map<Facility, Integer> map = new LinkedHashMap<>();

    @Override
    public void displayFacility() {
        map = ReadFile.readFileFacility(REGEX_FILE);
        for (Map.Entry<Facility, Integer> display : map.entrySet()) {
            System.out.println(display.getKey().toString() + "," + display.getValue());
        }
        WriteFile.writeFileFacility(map, REGEX_FILE);
    }

    @Override
    public void add() {
        map = ReadFile.readFileFacility(REGEX_FILE);
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
                WriteFile.writeFileFacility(map, REGEX_FILE);
                System.out.println("Thêm thành công");
                break;
            case 2:
                House house = this.infoHouse();
                map.put(house, 0);
                WriteFile.writeFileFacility(map, REGEX_FILE);
                System.out.println("Thêm thành công");
                break;
            case 3:
                Room room = this.infoRoom();
                map.put(room, 0);
                WriteFile.writeFileFacility(map, REGEX_FILE);
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
        map = ReadFile.readFileFacilityMaintenance(REGEX_FILE);
        for (Map.Entry<Facility, Integer> display : map.entrySet()) {
            System.out.println(display.getKey().toString() + "," + display.getValue());
        }
    }

    public Villa infoVilla() {
        String serviceCode;
        while (true) {
            System.out.println("Nhập mã dịch vụ");
            serviceCode = sc.nextLine();
            if (!checkRegex.checkServiceCodeVilla(serviceCode)) {
                System.out.println("Nhập mã sai,xin nhập lại:");
            } else {
                break;
            }
        }
        String serviceName;
        while (true) {
            System.out.println("Nhập tên dịch vụ");
            serviceName = sc.nextLine();
            if (!checkRegex.checkServiceName(serviceName)) {
                System.out.println("Nhập tên dịch vụ sai,xin nhập lại:");
            } else {
                break;
            }
        }
        double areaUse;
        while (true) {
            try {
                System.out.println("Nhập diện tích sử dụng");
                areaUse = Double.parseDouble(sc.nextLine());
                checkException.checkAreaUse(areaUse);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        double rentaClosts;
        while (true) {
            try {
                System.out.println("Nhập chi phí thuê");
                rentaClosts = Double.parseDouble(sc.nextLine());
                checkException.checkRentaClosts(rentaClosts);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        int people;
        while (true) {
            try {
                System.out.println("Nhập số lượng người tối đa");
                people = Integer.parseInt(sc.nextLine());
                checkException.checkPeople(people);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        String rentalType="";
        boolean isChoise=false;
        while (!isChoise) {
            System.out.println("Nhập kiểu thuê");
            System.out.println("1.Thuê theo năm");
            System.out.println("2.Thuê theo tháng");
            System.out.println("3.Thuê theo ngày");
            System.out.println("4.Thuê theo giờ");
            System.out.println("Mời chọn số:");
            try {
                int choise = Integer.parseInt(sc.nextLine());
                switch (choise){
                    case 1:
                        isChoise=true;
                        rentalType="Thuê theo năm";
                        break;
                    case 2:
                        isChoise=true;
                        rentalType="Thuê theo tháng";
                        break;
                    case 3:
                        isChoise=true;
                        rentalType="Thuê theo ngày";
                        break;
                    case 4:
                        isChoise=true;
                        rentalType="Thuê theo giờ";
                        break;
                    default:
                        System.out.println("Lựa chọn không đúng,mời chọn lại");
                }
            }catch (NumberFormatException e){
                System.out.println("Xin hãy nhập vào số");
            }
        }
        String roomStandard;
        while (true) {
            System.out.println("Nhập tiêu chuẩn phòng");
            roomStandard = sc.nextLine();
            if (!checkRegex.checkServiceName(roomStandard)) {
                System.out.println("viết hoa ký tự đầu, các ký tự sau là ký tự bình thường");
            } else {
                break;
            }
        }

        double poolArea;
        while (true) {
            try {
                System.out.println("Nhập diện tích hồ bơi");
                poolArea = Double.parseDouble(sc.nextLine());
                checkException.checkAreaUse(poolArea);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        int numberFloors;
        while (true) {
            try {
                System.out.println("Nhập số tầng");
                numberFloors = Integer.parseInt(sc.nextLine());
                checkException.checkNumberFloors(numberFloors);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }

        Villa villa = new Villa(serviceCode, serviceName, areaUse, rentaClosts, people, rentalType, roomStandard, poolArea, numberFloors);
        return villa;
    }

    public House infoHouse() {
        String serviceCode;
        while (true) {
            System.out.println("Nhập mã dịch vụ");
            serviceCode = sc.nextLine();
            if (!checkRegex.checkServiceCodeHouse(serviceCode)) {
                System.out.println("Nhập mã sai,xin nhập lại:");
            } else {
                break;
            }
        }
        String serviceName;
        while (true) {
            System.out.println("Nhập tên dịch vụ");
            serviceName = sc.nextLine();
            if (!checkRegex.checkServiceName(serviceName)) {
                System.out.println("Nhập tên dịch vụ sai,xin nhập lại:");
            } else {
                break;
            }
        }
        double areaUse;
        while (true) {
            try {
                System.out.println("Nhập diện tích sử dụng");
                areaUse = Double.parseDouble(sc.nextLine());
                checkException.checkAreaUse(areaUse);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        double rentaClosts;
        while (true) {
            try {
                System.out.println("Nhập chi phí thuê");
                rentaClosts = Double.parseDouble(sc.nextLine());
                checkException.checkRentaClosts(rentaClosts);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        int people;
        while (true) {
            try {
                System.out.println("Nhập số lượng người tối đa");
                people = Integer.parseInt(sc.nextLine());
                checkException.checkPeople(people);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        ;
        String rentalType="";
        boolean isChoise=false;
        while (!isChoise) {
            System.out.println("Nhập kiểu thuê");
            System.out.println("1.Thuê theo năm");
            System.out.println("2.Thuê theo tháng");
            System.out.println("3.Thuê theo ngày");
            System.out.println("4.Thuê theo giờ");
            System.out.println("Mời chọn số:");
            try {
                int choise = Integer.parseInt(sc.nextLine());
                switch (choise){
                    case 1:
                        isChoise=true;
                        rentalType="Thuê theo năm";
                        break;
                    case 2:
                        isChoise=true;
                        rentalType="Thuê theo tháng";
                        break;
                    case 3:
                        isChoise=true;
                        rentalType="Thuê theo ngày";
                        break;
                    case 4:
                        isChoise=true;
                        rentalType="Thuê theo giờ";
                        break;
                    default:
                        System.out.println("Lựa chọn không đúng,mời chọn lại");
                }
            }catch (NumberFormatException e){
                System.out.println("Xin hãy nhập vào số");
            }
        }
        System.out.println("Nhập tiêu chuẩn phòng");
        String roomStandard = sc.nextLine();
        int numberFloors;
        while (true) {
            try {
                System.out.println("Nhập số tầng");
                numberFloors = Integer.parseInt(sc.nextLine());
                checkException.checkNumberFloors(numberFloors);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        House house = new House(serviceCode, serviceName, areaUse, rentaClosts, people, rentalType, roomStandard, numberFloors);
        return house;
    }

    public Room infoRoom() {
        String serviceCode;
        while (true) {
            System.out.println("Nhập mã dịch vụ");
            serviceCode = sc.nextLine();
            if (!checkRegex.checkServiceCodeRoom(serviceCode)) {
                System.out.println("Nhập mã sai,xin nhập lại:");
            } else {
                break;
            }
        }
        String serviceName;
        while (true) {
            System.out.println("Nhập tên dịch vụ");
            serviceName = sc.nextLine();
            if (!checkRegex.checkServiceName(serviceName)) {
                System.out.println("Nhập tên dịch vụ sai,xin nhập lại:");
            } else {
                break;
            }
        }
        double areaUse;
        while (true) {
            try {
                System.out.println("Nhập diện tích sử dụng");
                areaUse = Double.parseDouble(sc.nextLine());
                checkException.checkAreaUse(areaUse);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        double rentaClosts;
        while (true) {
            try {
                System.out.println("Nhập chi phí thuê");
                rentaClosts = Double.parseDouble(sc.nextLine());
                checkException.checkRentaClosts(rentaClosts);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        int people;
        while (true) {
            try {
                System.out.println("Nhập số lượng người tối đa");
                people = Integer.parseInt(sc.nextLine());
                checkException.checkPeople(people);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        String rentalType="";
        boolean isChoise=false;
        while (!isChoise) {
            System.out.println("Nhập kiểu thuê");
            System.out.println("1.Thuê theo năm");
            System.out.println("2.Thuê theo tháng");
            System.out.println("3.Thuê theo ngày");
            System.out.println("4.Thuê theo giờ");
            System.out.println("Mời chọn số:");
            try {
                int choise = Integer.parseInt(sc.nextLine());
                switch (choise){
                    case 1:
                        isChoise=true;
                        rentalType="Thuê theo năm";
                        break;
                    case 2:
                        isChoise=true;
                        rentalType="Thuê theo tháng";
                        break;
                    case 3:
                        isChoise=true;
                        rentalType="Thuê theo ngày";
                        break;
                    case 4:
                        isChoise=true;
                        rentalType="Thuê theo giờ";
                        break;
                    default:
                        System.out.println("Lựa chọn không đúng,mời chọn lại");
                }
            }catch (NumberFormatException e){
                System.out.println("Xin hãy nhập vào số");
            }
        }
        System.out.println("Nhâp dịch vụ miễn phí đi kèm");
        String freeService = sc.nextLine();
        Room room = new Room(serviceCode, serviceName, areaUse, rentaClosts, people, rentalType, freeService);
        return room;
    }
}
