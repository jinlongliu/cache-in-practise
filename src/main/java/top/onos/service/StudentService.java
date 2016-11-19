package top.onos.service;

import top.onos.domain.Student;

import java.util.List;

/**
 * Created by Liu on 2016/11/18.
 */
public interface StudentService {

    int insertStudent(Student student);

    List<Student> getAll();

    boolean deleteStudent(int id);
}
