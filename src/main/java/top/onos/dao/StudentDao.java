package top.onos.dao;

import top.onos.domain.Student;

import java.util.List;

/**
 * Created by Liu on 2016/11/18.
 */
public interface StudentDao {
    int insertStudent(Student student);

    List<Student> getAll();

    int deleteStudent(int id);
}
