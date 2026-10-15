package repository;

import connection.StudentConnection;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void deleteStudent(int id){
        Connection connection=studentConnection.getconnection();
        String query="delete from student where id=?";
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setInt(1,id);
            ps.execute();
            System.out.println("data delete successfully");

        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public Student getStudent(String name){
        Connection connection=studentConnection.getconnection();
        String query="select * from student where name=? ";
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            Student student=new Student();
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));

            }
            return student;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
