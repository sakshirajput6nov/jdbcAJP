package service;

import entity.Student;
import repository.StudentRepository;

public class StudentService {
private StudentRepository studentRepository=new StudentRepository();
    public void insertStudent(Student student) {
        studentRepository.insertStudent(student);
    }
    public void deleteStudent(int id){studentRepository.deleteStudent(id);}
    public Student getStudent(String name) {
        return studentRepository.getStudent(name);
    }
}
