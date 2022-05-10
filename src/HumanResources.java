import java.util.ArrayList;
import java.util.Scanner;
public class HumanResources {
    //Khai báo biến arraylist để làm danh sách nhân viên
    public static ListStaff staffList = new ListStaff();
    public static Scanner sc = new Scanner(System.in);
    //Khai báo biến lưu trữ danh sách bộ phận
    public static ArrayList<Department> departmentList = new ArrayList<>();
    /**
     * Phương thức main điều hướng chương trình
     * @param args String[]
     */
    public static void main(String[] args) {
        // Biến chọn chức năng và điều kiện lặp
        int choice;
        // Vòng lặp điều khiển chương trình dựa vào giá trị nhập vào của biến choice
        do {
            System.out.println("Hãy lựa chọn chọn chúc năng: ");
            System.out.println(
                    """
                            1. Hiển thị danh sách nhân viên hiện có trong công ty
                            2. Nhập mã và tên bộ phận có trong công ty
                            3. Hiển thị các bộ phận trong công ty
                            4. Hiển thị các nhân viên theo từng bộ phận
                            5. Thêm nhân viên mới vào công ty
                            6. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
                            7. Hiển thị bảng lương của nhân viên toàn công ty
                            8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần
                            9. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần""");
            //Lưu giá trị biến choice từ giá trị nhập vào và so sánh với các điều kiện để thực hiện chức năng
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                staffList.displayAllStaff();
            } else if (choice == 2) {
                inputDepartment();
            } else if (choice == 3) {
                displayAllDepartment();
            } else if(choice == 4) {
                displayStaffFollowDepartment();
            } else if (choice == 5) {
                System.out.println("Hãy lựa chọn 1 trong 2 chức năng: ");
                System.out.println("1. Thêm nhân viên\n" +
                        "2. Thêm quản lý");
                choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    addEmployee();
                } else {
                    addManager();
                }
            } else if (choice == 6) {
                System.out.println("Hãy lựa chọn 1 trong 2 chức năng: ");
                System.out.println("1. Tìm theo tên nhân viên\n" +
                        "2. Tìm theo mã nhân viên");
                choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    System.out.println("Nhập tên nhân viên cần tìm: ");
                    String keyword = sc.nextLine();
                    staffList.findStaffByStaffName(keyword);
                } else {
                    System.out.println("Nhập mã nhân viên cần tìm: ");
                    String keyword = sc.nextLine();
                    staffList.findStaffByStaffCode(keyword);
                }
            } else if (choice == 7) {
                staffList.displaySalaryOfStaff();
            } else if (choice == 8) {
                staffList.displaySalaryListFollowUpperToLower();
            } else if (choice == 9) {
                staffList.displaySalaryListFollowLowerToUpper();
            }
        } while (choice != 0);

    }
    //Phương thức để nhập và thêm một nhân viên thường
    public static void addEmployee() {
        //Yêu cầu nhập và lưu trữ giá trị nhập vào các biến tương ứng
        System.out.println("Nhập mã nhân viên: ");
        String staffCode = sc.nextLine();
        System.out.println("Nhập tên nhân viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi nhân viên: ");
        int age = sc.nextInt();
        System.out.println("Nhập hệ số lương: ");
        double salaryCoefficients = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhập ngày vào: ");
        String joinedDay = sc.nextLine();
        System.out.println("Nhập mã bộ phận: ");
        String department = sc.nextLine();
        System.out.println("Nhập số ngày nghỉ phép còn lại: ");
        double annualLeave = sc.nextDouble();
        System.out.println("Nhập số giờ làm thêm: ");
        double overTimes = sc.nextDouble();
        //Khời tạo đối tượng nhân viên thường vừa nhập và thêm vào biến danh sách
        Employee employee = new Employee(staffCode, name, age, salaryCoefficients, joinedDay, department, annualLeave, overTimes);
        staffList.addStaff(employee);
    }
    //Phương thức nhập và thêm một nhân viên quản lý
    public static void addManager() {
        //Yêu cầu nhập và lưu trữ giá trị nhập vào các biến tương ứng
        System.out.println("Nhập mã quản lý: ");
        String staffCode = sc.nextLine();
        System.out.println("Nhập tên quản lý: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi quản lý: ");
        int age = sc.nextInt();
        System.out.println("Nhập hệ số lương: ");
        double salaryCoefficients = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhập ngày vào: ");
        String joinedDay = sc.nextLine();
        System.out.println("Nhap mã bộ phận: ");
        String department = sc.nextLine();
        System.out.println("Nhập số ngày nghỉ phép còn lại: ");
        double annualLeave = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhập chức vụ: ");
        String position = sc.nextLine();
        //Khời tạo đối tượng nhân viên quản lý vừa nhập và thêm vào biến danh sách
        Manager manager = new Manager(staffCode, name, age, salaryCoefficients, joinedDay, department, annualLeave, position);
        staffList.addStaff(manager);
    }
    //Phương thức nhập và thêm bộ phận
    public static void inputDepartment() {
        //Nhập thông tin bộ phận và lưu tương ứng vào các biến
        System.out.println("Hãy nhập mã và tên bộ phận của công ty: ");
        System.out.println("Mã bộ phận: "); String departmentCode = sc.nextLine();
        System.out.println("Nhập tên bộ phận: "); String departmentName = sc.nextLine();
        //Khởi tạo đối tượng bộ phận vừa nhập và thêm vào danh sách biến bộ phận
        Department department = new Department(departmentCode, departmentName);
        departmentList.add(department);
    }
    //Phương thức hiển thị các bộ phận trong công ty
    public static void displayAllDepartment() {
        //Vòng lặp tính toán số lượng nhân viên cho từng bộ phận
        for (Department department : departmentList) {
            for (Staff staff : staffList.myList) {
                if (staff.getDepartment().equals(department.departmentCode)) {
                    department.numberofStaff += 1;
                }
            }
        }
        //Hiển thị thông tin bộ phận sau khi tính toán số lượng nhân viên theo bộ phận
        for (Department department : departmentList) {
            System.out.println(department.toString());
        }
        System.out.println();
    }
    //Phương thức hiển thị nhân viên theo từng bộ phận
    public static void displayStaffFollowDepartment() {
        for (Department department : departmentList) {
            System.out.println(department.toString());
            for (Staff staff : staffList.myList) {
                if (staff.getDepartment().equals(department.departmentCode)) {
                    staff.displayInformation();
                }
            }
            System.out.println();
        }
    }
}
