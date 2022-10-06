package furama_resort.service.impl;

import furama_resort.model.Customer;
import furama_resort.service.ICustomerService;
import furama_resort.utils.checks.Check;
import furama_resort.utils.checks.CheckException;
import furama_resort.utils.checks.CheckRegexFacility;
import furama_resort.utils.write_and_read.ReadFile;
import furama_resort.utils.write_and_read.WriteFile;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private static final String REGEX_FILE = "src/furama_resort/data/customer.csv";
    List<Customer> customerList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    CheckRegexFacility checkRegexFacility = new CheckRegexFacility();
    CheckException checkException=new CheckException();

    @Override
    public void display() {
        customerList = ReadFile.readFileCustomer(REGEX_FILE);
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        WriteFile.writeFileCustomer(customerList, REGEX_FILE);
    }

    @Override
    public void add() {
        customerList = ReadFile.readFileCustomer(REGEX_FILE);

        Customer customer = this.info();
        customerList.add(customer);
        WriteFile.writeFileCustomer(customerList, REGEX_FILE);
        System.out.println("Thêm thành công");

    }

    @Override
    public void edit() {
        customerList = ReadFile.readFileCustomer(REGEX_FILE);
        int id;
        while (true) {
            try {
                System.out.println("Nhập mã khách hàng cần sửa thông tin:");
                id = Integer.parseInt(sc.nextLine());
                checkException.checkNumber(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Xin hãy nhập số:");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        Customer customer;
        boolean isId = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                customerList.remove(i);
                System.out.println("Nhập các thông tin mới:");
                customer = this.info();
                customerList.add(i, customer);
                System.out.println("Sửa thành công");
                isId = true;
                break;
            }
        }
        if (!isId) {
            System.out.println("Không tìm thấy mã khách hàng cần sửa");
        }
        WriteFile.writeFileCustomer(customerList, REGEX_FILE);
    }

    public Customer info() {
        int id;
        while (true) {
            try {
                System.out.println("Nhập mã số khách hàng :");
                id = Integer.parseInt(sc.nextLine());
                checkException.checkNumber(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Xin hãy nhập số:");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }

        String name;
        while (true) {
            System.out.println("Nhập họ tên khách hàng:");
            name = sc.nextLine();
            if (!checkRegexFacility.checkName(name)) {
                System.out.println("Nhập tên sai định dạng,xin nhập lại:");
            } else {
                break;
            }
        }

        LocalDate birthday;
        while (true) {
            System.out.println("Nhập ngày sinh khách hàng theo định dạng dd/MM/yyyy:");
            try {
                birthday = LocalDate.parse(sc.nextLine(), formatter);
                LocalDate date = LocalDate.now();
                Period checkAge = Period.between(birthday, date);
                if (checkAge.getYears() < 18 || checkAge.getYears() > 100) {
                    throw new DateTimeException("Tuổi phải nằm trong khoảng từ 18-100");
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày sinh sai định dạng ,xin nhập lại:");
            } catch (DateTimeException e) {
                System.out.println(e.getMessage());
            }
        }
        String gender = "";
        boolean isChoise=false;
        while (!isChoise) {
            System.out.println("Nhập giới tính khách hàng:");
            System.out.println("1.Nam");
            System.out.println("2.Nữ");
            System.out.println("3.LJBT");
            try {
                int choise = Integer.parseInt(sc.nextLine());
                switch (choise) {
                    case 1:
                        isChoise=true;
                        gender = "Nam";
                        break;
                    case 2:
                        isChoise=true;
                        gender = "Nữ";
                        break;
                    case 3:
                        isChoise=true;
                        gender = "LJBT";
                        break;
                    default:
                        System.out.println("Nhập không đúng,vui lòng nhập lại");
                }
            } catch (NumberFormatException e) {
                System.out.println("Xin hãy nhập vào số");
            }
        }
        String identityCard;
        while (true) {
            System.out.println("Nhập CMND khách hàng gồm 9 số hoặc 12 số:");
            identityCard = sc.nextLine();
            if (!checkRegexFacility.checkIdentityCard(identityCard)) {
                System.out.println("Nhập sai định dạng,xin nhập lại:");
            } else {
                break;
            }
        }
        String phoneNumber;
        while (true) {
            System.out.println("Nhập số điện thoại khách hàng +84XXXXXXXXX:");
            phoneNumber = sc.nextLine();
            if (!checkRegexFacility.checkPhoneNumber(phoneNumber)) {
                System.out.println("Nhập số điện thoại sai định dạng,xin nhập lại:");
            } else {
                break;
            }
        }

        String email;
        while (true) {
            System.out.println("Nhập email khách hàng:");
            email = sc.nextLine();
            if (!checkRegexFacility.checkEmail(email)) {
                System.out.println("Nhập email không hợp lệ,xin nhập lại:");
            } else {
                break;
            }
        }
        isChoise=false;
        String customerType = "";
        while (!isChoise) {
            System.out.println("Chọn loại khách hàng:");
            System.out.println("1.Diamond");
            System.out.println("2.Platinium");
            System.out.println("3.Gold");
            System.out.println("4.Silver");
            System.out.println("5.Member");
            System.out.println("Mời chọn số");
            try {
                int choise = Integer.parseInt(sc.nextLine());
                switch (choise) {
                    case 1:
                        isChoise=true;
                        customerType = "Diamond";
                        break;
                    case 2:
                        isChoise=true;
                        customerType = "Platinium";
                        break;
                    case 3:
                        isChoise=true;
                        customerType = "Gold";
                        break;
                    case 4:
                        isChoise=true;
                        customerType = "Silver";
                        break;
                    case 5:
                        isChoise=true;
                        customerType = "Member";
                        break;
                    default:
                        System.out.println("Mời chọn lại:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số:");
            }
        }
        String address;
        while (true) {
            System.out.println("Nhập địa chỉ khách hàng:");
            address = sc.nextLine();
            if (!checkRegexFacility.checkAddress(address)) {
                System.out.println("Nhập địa chỉ không hợp lệ,xin nhập lại:");
            } else {
                break;
            }
        }
        Customer customer = new Customer(id, name, birthday, gender, identityCard, phoneNumber, email, customerType, address);
        return customer;
    }
}
