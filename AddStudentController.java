package controller;

import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;
@WebServlet("/addStudent")
public class AddStudentController extends HttpServlet {
    private StudentService studentService=new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student =new Student();
        student.setName(request.getParameter("name"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setAddress(request.getParameter("address"));
        studentService.insertStudent(student);
    }
}
