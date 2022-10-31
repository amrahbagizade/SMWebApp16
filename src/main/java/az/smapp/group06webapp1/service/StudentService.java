package az.smapp.group06webapp1.service;
import az.smapp.group06webapp1.DB.DB;
import az.smapp.group06webapp1.dao.StudentDao;
import az.smapp.group06webapp1.entity.Student;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public final class StudentService {

    public static void addStudent(Student student) throws SQLException {
        StudentDao.addStudent(student); //obyekti Dao-ya gonderirik
        //  DB.studentsTable.put(UUID.randomUUID().toString(), student);

    }

    public static List<Student> getAllStudents() throws SQLException {
     return StudentDao.getAllStudent();
    }

    public static Student getOneStudent(Long id) throws SQLException {
        return StudentDao.getStudentById(id);

    }

    public static void updateStudent() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("UPDATE STUDENT");
        getAllStudents();
        System.out.println("Deyishiklik ucun telebenin id-sini daxil edin:");
        String id = input.nextLine();
//        Student student = DB.studentsTable.get(id);
        Student student = StudentDao.getStudentById(Long.valueOf(id)); //Id-e gore telebeni axtaririq.
        System.out.println("Telebenin adini daxil edin:");
        String name = input.nextLine();
        student.setName(name);

        System.out.println("Telebenin soyadini daxil edin:");
        String surname = input.nextLine();
        student.setSurname(surname);

        System.out.println("Telebenin emailini daxil edin:");
        String email = input.nextLine();
        student.setEmail(email);

        System.out.println("Telebenin nomresini daxil edin:");
        String phone = input.nextLine();
        student.setPhone(phone);
        StudentDao.updateStudentById(student); // yeni yaratdigimiz objecti atiriq metoda

    }

    public static void deleteStudent() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("DELETE STUDENT STUDENT");
        getAllStudents();
        System.out.println("Silmek uchun telebenin ID-sini daxil edin:");
        String id = input.nextLine();
        DB.studentsTable.remove(id);


    }
}
