package service;

import entity.Student;
import repository.StudentRepository;

public class StudentService {
private StudentRepository studentRepository=new StudentRepository();
    public void insertStudent(Student student) {
        studentRepository.insertStudent(student);
    }
}
