/**
 * Class lưu trữ và quản lý thông tin của nhân viên thường trong công ty, class con của Staff và interface ICalculator
 * Có các phương thức: tính toán lương, hiển thị thông tin, hiển thị lương
 */
public class Employee extends Staff implements ICalculator {
    private double overTimes;
    //Hàm khởi tạo
    public Employee(String staffCode, String name, int age, double salaryCoefficients, String joinedDay,
                    String department, double annualLeave, double overTimes) {
        super(staffCode, name, age, salaryCoefficients, joinedDay, department,annualLeave);
        this.overTimes = overTimes;
    }

    //Hàm tính toán và trả về giá trị lương
    @Override
    public double calculateSalary() {
        return super.getSalaryCoefficients()*3000000 + this.overTimes*200000;
    }
    //Hàm hiển thị thông tin nhân viên
    @Override
    public void displayInformation() {
        System.out.println("[MSNV: " + super.getStaffCode() + "] "+ "[Họ và tên: " + super.getName() + "] " +
                "[Tuổi: " + super.getAge() + "] "+ "[Bộ phận: " + super.getDepartment() + "] "+ "[Ngày vào công ty: " +
                super.getJoinedDay() + "[Số ngày phép còn lại: "+ super.getAnnualLeave() + "]" + "[Số giờ làm thêm: "+ this.overTimes + "]");
    }
    //Hàm hiển thị lương của nhân viên
    @Override
    public void displaySalary() {
        super.setSalary(this.calculateSalary());
        System.out.print("[MSNV: " + super.getStaffCode() + ", "+ "Họ và tên: " + super.getName() + ", " +
                "Bộ phận: " + super.getDepartment() + ", " + "Giờ làm thêm: "+ this.overTimes + ", ");
        System.out.printf("Tổng lương = %8.1f", super.getSalary());
        System.out.println("]");
    }
}
