package dao;

import entity.Student;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<Student> findAll(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> listStudent = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_student()}");
            ResultSet rs = callSt.executeQuery();
            listStudent = new ArrayList<>();
            while (rs.next()){
                Student student = new Student();
                student.setStudent_Id(rs.getInt("Student_Id"));
                student.setFull_Name(rs.getString("Full_Name"));
                student.setEmail(rs.getString("Email"));
                student.setPhone_Number(rs.getString("Phone_Number"));
                student.setRegister_Date(LocalDate.parse(rs.getString("Register_Date"),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                student.setStatus(rs.getBoolean("Status"));
                listStudent.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStudent;
    }

    public static boolean createStudent(Student student){
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_student(?,?,?,?)}");
            callSt.setString(1, student.getFull_Name());
            callSt.setString(2, student.getEmail());
            callSt.setString(3,student.getPhone_Number());
            callSt.setString(4, student.getRegister_Date().toString());
            callSt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    public static Student findById(String studentId){
        Connection conn = null;
        CallableStatement callSt = null;
        Student student = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_student_by_id(?)}");
            callSt.setString(1, studentId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()){
                student = new Student();
                student.setStudent_Id(rs.getInt("Student_Id"));
                student.setFull_Name(rs.getString("Full_Name"));
                student.setEmail(rs.getString("Email"));
                student.setPhone_Number(rs.getString("Phone_Number"));
                student.setRegister_Date(LocalDate.parse(rs.getString("Register_Date"),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                student.setStatus(rs.getBoolean("Status"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return student;
    }

    public static boolean updateStudent(Student student){
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_student(?,?,?,?,?,?)}");
            callSt.setInt(1, student.getStudent_Id());
            callSt.setString(2, student.getFull_Name());
            callSt.setString(3, student.getEmail());
            callSt.setString(4,student.getPhone_Number());
            callSt.setString(5, student.getRegister_Date().toString());
            callSt.setBoolean(6, student.isStatus());
            callSt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    public static boolean deleteStudentById(String studentId){
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_student(?)}");
            callSt.setInt(1, Integer.parseInt(studentId));
            callSt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    public static List<Student> searchStudentByName(String studentName){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> listStudent = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_student_by_name(?)}");
            callSt.setString(1, studentName);
            ResultSet rs = callSt.executeQuery();
            listStudent = new ArrayList<>();
            while (rs.next()){
                Student student = new Student();
                student.setStudent_Id(rs.getInt("Student_Id"));
                student.setFull_Name(rs.getString("Full_Name"));
                student.setEmail(rs.getString("Email"));
                student.setPhone_Number(rs.getString("Phone_Number"));
                student.setRegister_Date(LocalDate.parse(rs.getString("Register_Date"),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                student.setStatus(rs.getBoolean("Status"));
                listStudent.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStudent;
    }
}
