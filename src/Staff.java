/**
 * Class trừu tượng chứa thông tin và phương thức nhân viên trong công ty
 */
public abstract class Staff implements ICalculator {
    private String staffCode;
    private String name;
    private int age;
    private double salaryCoefficients;
    private final String joinedDay;
    private String department;
    private double annualLeave;
    private double salary;
    //Hàm khời tạo
    public Staff(String staffCode, String name, int age, double salaryCoefficients, String joinedDay,
                 String department, double annualLeave) {
        this.staffCode = staffCode;
        this.name = name;
        this.age = age;
        this.salaryCoefficients = salaryCoefficients;
        this.joinedDay = joinedDay;
        this.department = department;
        this.annualLeave = annualLeave;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalaryCoefficients() {
        return salaryCoefficients;
    }

    public String getDepartment() {
        return department;
    }

    public String getJoinedDay() {
        return joinedDay;
    }

    public double getAnnualLeave() {
        return annualLeave;
    }

    //Hàm trả về giá trị lương của nhân viên
    public double getSalary() {
        return salary;
    }
    //Hàm gán giá trị lương
    public void setSalary(double salary) {
        this.salary = salary;
    }
    //Phương thức trừu tượng hiển thị thông tin
    public abstract void displayInformation();
    //Phương thức trừu tượng hiển thị lương nhân viên
    public abstract void displaySalary();

}
