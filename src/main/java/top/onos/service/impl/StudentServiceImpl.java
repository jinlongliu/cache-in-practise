package top.onos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.onos.dao.StudentDao;
import top.onos.domain.Student;
import top.onos.service.StudentService;

import java.util.List;

/**
 * Created by Liu on 2016/11/18.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int insertStudent(Student student) {
        int id = studentDao.insertStudent(student);
        return id;
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public boolean deleteStudent(int id) {
        int affectLine = studentDao.deleteStudent(id);
        if (affectLine > 0) {
            return true;
        } else {
            return false;
        }
    }
}
