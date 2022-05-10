import java.util.ArrayList;
/**
 * Class lưu trữ và quản lý danh sách tất cả nhân viên trong công ty
 */
public class ListStaff {
    ArrayList<Staff> myList;
    //Phương thức khởi tạo
    public ListStaff() {
        this.myList = new ArrayList<>();
    }
    //Phương thức thêm một đối tượng vào danh sách
    public void addStaff(Staff employee) {
        this.myList.add(employee);
    }
    //Phương thức hiển thị toàn bộ nhân viên
    public void displayAllStaff() {
        System.out.println("Danh sách nhân viên trong công ty: ");
        for (Staff staff  : myList) {
            staff.displayInformation();
        }
        System.out.println();
    }
    // PHương thức tìm nhân viên theo mã nhân viên
    public void findStaffByStaffCode(String keysearch) {
        for (Staff staff  : myList) {
            if (staff.getStaffCode().toLowerCase().contains(keysearch.toLowerCase())) {
                System.out.println("[MSNV: " + staff.getStaffCode() + "] "+ "[Họ và tên: " + staff.getName() + "] " +
                        "[Tuổi: " + staff.getAge() + "] "+ "[Bộ phận: " + staff.getDepartment() + "] "+ "[Ngày vào công ty: " +
                        staff.getJoinedDay() + "]");
            }
        }
        System.out.println();
    }
    //Phương thức tìm nhần viên theo tên nhân viên
    public void findStaffByStaffName(String keysearch) {
        for (Staff staff  : myList) {
            if (staff.getName().toLowerCase().contains(keysearch.toLowerCase())) {
                staff.displayInformation();
            }
        }
        System.out.println();
    }
    //Phương thức hiển thị danh sách lương
    public void displaySalaryOfStaff() {
        System.out.println("Bản lương nhân viên trong công ty: ");
        for (Staff staff  : myList) {
            staff.displaySalary();
        }
        System.out.println();
    }
    //Phương thức sắp xếp và hiển thị lương giảm dần
    public void displaySalaryListFollowUpperToLower() {
        //Gán giá trị cho thuộc tính salary, lương của nhân viên
        for (Staff staff  : myList) {
            staff.setSalary(staff.calculateSalary());
        }
        //So sánh lương và sắp xếp lại danh sách nhân viên giảm dần theo lương
        this.myList.sort((st1, st2) -> {
            if (st1.getSalary() < st2.getSalary()) {
                return 1;
            } else if (st1.getSalary() > st2.getSalary()) {
                return -1;
            }
            return 0;
        });
        //Vòng lặp hiển thị danh sách lương sau khi sắp xếp
        for (Staff staff : myList) {
            staff.displaySalary();
        }
        System.out.println();
    }
    //Phương thức sắp xếp và hiển thị lương nhân viên tăng dần
    public void displaySalaryListFollowLowerToUpper() {
        //Gán giá trị cho thuộc tính salary, lương của nhân viên
        for (Staff staff  : myList) {
            staff.setSalary(staff.calculateSalary());
        }
        //So sánh lương và sắp xếp lại danh sách nhân viên từ thấp đến cao theo lương
        this.myList.sort((st1, st2) -> {
            if (st1.getSalary() < st2.getSalary()) {
                return -1;
            } else if (st1.getSalary() > st2.getSalary()) {
                return 1;
            }
            return 0;
        });
        //Vòng lặp hiển thị danh sách lương sau khi sắp xếp
        for (Staff staff : myList) {
            staff.displaySalary();
        }
        System.out.println();
    }
}
