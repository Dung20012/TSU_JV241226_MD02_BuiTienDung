create database student_management_db;
use student_management_db;

create table Student(
	Student_Id int primary key auto_increment,
    Full_Name varchar(100) not null,
    Email varchar(100) not null unique,
    Phone_Number varchar(15) not null,
    Register_Date date not null,
    Status bit default 1
);

# Procedure
-- Lấy danh sách tất cả sinh viên
DELIMITER //
create procedure find_all_student()
begin
	select * from Student;
end //
DELIMITER ;

-- Thêm mới sinh viên
DELIMITER //
create procedure create_student(
	in Name_in varchar(100),
    in Email_in varchar(100),
    in Number_in varchar(15),
    in Date_in date
)
begin 
	insert into Student(Full_Name, Email, Phone_Number, Register_Date)
    values (Name_in, Email_in, Number_in, Date_in);
end //
DELIMITER ;

-- Lấy thông tin sinh viên theo mã sinh viên
DELIMITER //
create procedure find_student_by_id(in id_in int)
begin
	select * from Student where Student_Id = id_in;
end //
DELIMITER ;

-- Cập nhật thông tin sinh viên
DELIMITER //
create procedure update_student(
	in Id_in int,
    in Name_in varchar(100),
    in Email_in varchar(100),
    in Number_in varchar(15),
    in Date_in date,
    in Status_in bit
)
begin
	update Student 
    set Full_Name = Name_in,
		Email = Email_in,
        Phone_Number = Number_in,
        Register_Date = Date_in,
        Status = Status_in
	where Student_Id = id_in;
end //
DELIMITER ;

-- Xóa sinh viên
DELIMITER //
create procedure delete_student(in id_in int)
begin
	delete from Student where Student_Id = id_in;
end //
DELIMITER ;

-- Tìm kiếm sinh viên theo tên (gần đúng)
DELIMITER //
create procedure find_student_by_name(in Name_in varchar(100))
begin
	declare search varchar(100);
    set search = concat('%', Name_in,'%');
    select * from Student where Full_Name like search;
end //
DELIMITER ;