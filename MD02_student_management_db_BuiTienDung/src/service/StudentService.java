package service;

import dao.StudentDAO;
import entity.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    public static void displayStudent(){
        List<Student> listStudent = StudentDAO.findAll();
        listStudent.forEach(System.out::println);
    }

    public static void createStudent(Scanner scanner){
        Student student = new Student();
        student.inputData(scanner);
        boolean result = StudentDAO.createStudent(student);
        if (result){
            System.out.println("Thêm mới thành công !");
        }else {
            System.err.println("Thêm mới thất bại !");
        }
    }

    public static void updateStudent(Scanner scanner){
        System.out.println("Nhập vào mã sinh viên cần cập nhật: ");
        String id = scanner.nextLine();
        Student student = StudentDAO.findById(id);
        if (student != null){
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sinh viên");
                System.out.println("2. Cập nhật Email");
                System.out.println("3. Cập nhật SĐT");
                System.out.println("4. Cập nhật ngày đăng ký");
                System.out.println("5. Thoát");
                System.out.println("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập vào tên sinh viên mới: ");
                        student.setFull_Name(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào Email mới: ");
                        student.setEmail(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào SĐT mới: ");
                        student.setPhone_Number(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập vào ngày đăng ký mới: ");
                        String date = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate date1 = LocalDate.parse(date, formatter);
                        student.setRegister_Date(date1);
                        break;
                    case 5:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1 - 4");
                }
            }while (isExit);
            // Cập nhật
            boolean result = StudentDAO.updateStudent(student);
            if (result){
                System.out.println("Thêm mới thành công !");
            }else {
                System.err.println("Thêm mới thất bại !");
            }
        }
    }

    public static void deleteStudent(Scanner scanner){
        System.out.println("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();
        Student student = StudentDAO.findById(id);
        if (student != null){
            boolean result = StudentDAO.deleteStudentById(id);
            if (result){
                System.out.println("Xóa thành công !");
            }else {
                System.err.println("Xóa thất bại !");
            }
        }
    }

    public static void searchStudentByName(Scanner scanner){
        System.out.println("Nhập vào tên sinh viên cần tìm: ");
        String studentName = scanner.nextLine();
        List<Student> listStudent = StudentDAO.searchStudentByName(studentName);
        System.out.println("Kết quả tìm kiếm: ");
        listStudent.forEach(System.out::println);
    }

    public static void sortStudentRegisterDate(){
        List<Student> listStudent = StudentDAO.findAll();
        System.out.println("Kết quả sắp xếp: ");
        listStudent.stream().sorted(Comparator.comparing(Student::getRegister_Date))
                .forEach(System.out::println);
    }
}
