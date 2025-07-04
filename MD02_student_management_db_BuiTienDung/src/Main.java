import dao.StudentDAO;
import service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*****************STUDENT MANAGEMENT*****************");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo tên");
            System.out.println("6. Sắp xếp sinh viên theo ngày đăng ký");
            System.out.println("7. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    StudentService.displayStudent();
                    break;
                case 2:
                    StudentService.createStudent(scanner);
                    break;
                case 3:
                    StudentService.updateStudent(scanner);
                    break;
                case 4:
                    StudentService.deleteStudent(scanner);
                    break;
                case 5:
                    StudentService.searchStudentByName(scanner);
                    break;
                case 6:
                    StudentService.sortStudentRegisterDate();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 - 7");

            }
        }while (true);
    }
}
