package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Student {
    private int Student_Id;
    private String Full_Name;
    private String Email;
    private String Phone_Number;
    private LocalDate Register_Date;
    private boolean Status;

    public Student() {
    }

    public Student(int student_Id, String full_Name, String email, String phone_Number, LocalDate register_Date, boolean status) {
        Student_Id = student_Id;
        Full_Name = full_Name;
        Email = email;
        Phone_Number = phone_Number;
        Register_Date = register_Date;
        Status = status;
    }

    public int getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(int student_Id) {
        Student_Id = student_Id;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String full_Name) {
        Full_Name = full_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public LocalDate getRegister_Date() {
        return Register_Date;
    }

    public void setRegister_Date(LocalDate register_Date) {
        Register_Date = register_Date;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    @Override
    public String toString() {
        return String.format("Mã sinh viên: %d - Tên sinh viên: %s - Email: %s\n SĐT: %s - Ngày đăng ký: %s - Trạng thái: %s",
                Student_Id, Full_Name, Email, Phone_Number, Register_Date,Status ? "Hoạt động" : "Không hoạt động");
    }

    public void inputData(Scanner scanner){
        System.out.println("Nhập vào tên sinh viên: ");
        this.setFull_Name(scanner.nextLine());
        System.out.println("Nhập vào Email: ");
        this.setEmail(scanner.nextLine());
        System.out.println("Nhập vào SĐT: ");
        this.setPhone_Number(scanner.nextLine());
        System.out.println("Nhập vào ngày đăng ký: ");
        String date = scanner.nextLine();
        this.Register_Date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
