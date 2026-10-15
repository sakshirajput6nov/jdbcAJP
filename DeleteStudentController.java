package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;
@WebServlet("/deleteStudent")
public class DeleteStudentController extends HttpServlet {
    private StudentService studentService=new StudentService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        int id=Integer.parseInt(req.getParameter("id"));
        studentService.deleteStudent(id);

    }
}
