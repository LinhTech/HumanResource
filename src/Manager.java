/**
 * Class lưu trữ và quản lý thông tin của quản lý trong công ty, class con của Staff và interface ICalculator
 * Có các phương thức: tính toán lương, hiển thị thông tin, hiển thị lương
 */
public class Manager extends Staff implements ICalculator {
    private String position;
    //Hàm khởi tạo
    public Manager(String staffCode, String name, int age, double salaryCoefficients, String joinedDay,
                   String department, double annualLeave, String position) {
        super(staffCode, name, age, salaryCoefficients, joinedDay, department,annualLeave);
        this.position = position;
    }

    //Hàm tính toán và trả về giá trị lương
    @Override
    public double calculateSalary() {
        if (position.equals("Business Leader")) {
            return super.getSalaryCoefficients()*5000000 + 8000000;
        }
        if (position.equals("Project Leader")) {
            return super.getSalaryCoefficients()*5000000 + 5000000;
        }
        if (position.equals("Technical Leader")) {
            return super.getSalaryCoefficients()*5000000 + 6000000;
        }
        return super.getSalaryCoefficients()*5000000;
    }
    //Hàm hiển thị thông tin nhân viên
    @Override
    public void displayInformation() {
        System.out.println("[MSNV: " + super.getStaffCode() + "] "+ "[Họ và tên: " + super.getName() + "] " +
                "[Tuổi: " + super.getAge() + "] "+ "[Bộ phận: " + super.getDepartment() + "] "+ "[Ngày vào công ty: " +
                super.getJoinedDay() + "[Số ngày phép còn lại: "+ super.getAnnualLeave() + "] " + "[Chức vụ: "+ this.position + "]");
    }
    //Hàm hiển thị lương của nhân viên
    @Override
    public void displaySalary() {
        super.setSalary(this.calculateSalary());
        System.out.print("[MSNV: " + super.getStaffCode() + ", "+ "Họ và tên: " + super.getName() + ", " +
                "Bộ phận: " + super.getDepartment() + ", " + "Chức vụ: "+ this.position + ", ");
        System.out.printf("Tổng lương = %8.1f", super.getSalary());
        System.out.println("]");
    }
}
