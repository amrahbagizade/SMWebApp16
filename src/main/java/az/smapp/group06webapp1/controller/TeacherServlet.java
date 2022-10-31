package az.smapp.group06webapp1.controller;


import az.smapp.group06webapp1.entity.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "teacherServlet", value = "/teacher-servlet")
public class TeacherServlet extends HttpServlet {
    private List<Teacher> teacherList = List.of(
            new Teacher(1,"Elmir","Taghisoy", "elmir@mail.ru","0502354673"),
            new Teacher(2,"Mahmud","Mahmudov","mahmud@mail.ru","0702345671"),
            new Teacher(3,"Emrah","Bagizada","amrah@mail.ru","0505842878"),
            new Teacher (4,"Amina","Ismayilzada","amina@mail.ru","0552348182")
    );
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", teacherList);
        String address = "teacher.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

}
