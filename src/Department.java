/**
 * Class lưu trữ và quản lý thông tin của các bộ phận trong công ty
 */
public class Department {
    String departmentCode;
    String departmentName;
    int numberofStaff;
    //Hàm khởi tạo
    public Department(String departmentCode, String departmentName) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.numberofStaff = 0;
    }
    //Hàm hiển thị thông tin của bộ phận
    @Override
    public String toString(){
        return "Mã BP: " + this.departmentCode + ", Tên BP: " + this.departmentName + ", Số lượng NV: " + this.numberofStaff + "]";
    }

}
