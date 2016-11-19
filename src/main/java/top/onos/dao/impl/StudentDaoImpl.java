package top.onos.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.onos.dao.StudentDao;
import top.onos.domain.Student;
import top.onos.mapper.StudentMapper;

import java.util.List;

/**
 * Created by Liu on 2016/11/18.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int insertStudent(Student student) {
        int id = studentMapper.insertStudent(student);
        return id;
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll("getAll");
    }

    @Override
    public int deleteStudent(int id) {
        int affectLines = studentMapper.deleteStudent(id);
        return affectLines;
    }
}
