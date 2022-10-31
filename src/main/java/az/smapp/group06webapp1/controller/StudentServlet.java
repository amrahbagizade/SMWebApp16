package az.smapp.group06webapp1.controller;

import az.smapp.group06webapp1.entity.Student;
import az.smapp.group06webapp1.service.StudentService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name ="studentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response); //post metodunu ishlek veziyyete getirir
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            processRequest(request, response);  //get metodunu ishlek veziyyete getirir.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String action = null;
        String address = null;
        boolean isPost = false;

        if (request.getParameter("action") != null) //action null deyilse eger
        {
            action = request.getParameter("action");
//            action-dan requesti goturmushdu parametr kimi
        }
        if (action.equalsIgnoreCase("studentList")) {
            List<Student> studentList = StudentService.getAllStudents(); //getAllStudents sadece consolda capa verir deye
            // biz onu studentList-e atmaliyiq amma evvelce bu metodu void-den Liste ceviririk

            request.setAttribute("list", studentList);
            address = "student.jsp";
        } else if (action.equalsIgnoreCase("addStudentView")) {
            address = "addStudent.jsp";
        } else if (action.equalsIgnoreCase("updateStudentView")) {
            address = "updateStudent.jsp";
        } else if (action.equalsIgnoreCase("addStudent")) {
            Student student = new Student();
            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("surname"));
            student.setEmail(request.getParameter("email"));
            student.setPhone(request.getParameter("phone"));
            StudentService.addStudent(student); // obyekti service gonderirik
//            studentList.add(student); //indide yaratdigimiz obyekti melumatlari ile bir yerde add edirik Listin ichine
//            Save etdikden sonra ele etmeliyiik ki avtomatik cedvel sehifesine qayitsin:
            isPost = true; //eger melumat elave olundusa ashagidaki URL-e redirect(ötur) ele
            address = "/Group06WebApp1_war_exploded/student-servlet?action=studentList";
        }else if (action.equalsIgnoreCase("updateStudent")) {

           Student student = StudentService.getOneStudent(Long.valueOf(request.getParameter("id")));
            request.setAttribute("student", student);
           address = "updateStudent.jsp";}

        if(isPost){
            response.sendRedirect(address); //eger melumat elave olundusa ashagidaki URL-e redirect(ötur) ele
        }
        else{ //Eger post olunmayibsa normal evvelki halda ekrana cixardacaq
        RequestDispatcher dispatcher = request.getRequestDispatcher(address); //dispatcher obyektimizde
        // student.jsp yaranmish olur
        dispatcher.forward(request, response); // melumatlara request edib ekrana capa vermek ucun
    }
}}











//    private List<Student> studentList = List.of(
//    new Student(1,"Elmir","Taghisoy", "elmir@mail.ru","0502354673")..) - list,of ile yaradanda bir nov onu
//  final kimi qebul edir. icine yeni nese elave ede bilmirik
//    private List<Student> studentList = new ArrayList<>();
//
//    {
//        new Student(1L, "Elmir", "Taghisoy", "elmir@mail.ru", "0502354673");
//                new Student(2L, "Mahmud", "Mahmudov", "mahmud@mail.ru", "0702345671");
//                new Student(3L, "Emrah", "Bagizada", "amrah@mail.ru", "0505842878");
//                new Student(4L, "Amina", "Ismayilzada", "amina@mail.ru", "0552348182");
//    }
//bazadaki table-dan chekilmis bir melumatlardir
//static{}- classa aid olan ve instance bloklar(obyekte aid olan):{}- bunlarin hec bir funksiyasi yoxdur.
// normalda ilk konstruktor ishe dushur.
// Amma bu anlayislar daxil eilderse birinci bunlar ishe dushur
// Sadece obyekt ve yaxudda class yaradilanda bunlar
//birinci ise dusurler