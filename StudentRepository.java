package repository;

import connection.StudentConnection;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRepository {
    StudentConnection studentConnection=new StudentConnection();
    public void insertStudent(Student student) {
        Connection connection=studentConnection.getconnection();
        String query="insert into student(name,age,address) values(?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getAddress());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
