package top.onos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.onos.domain.Student;
import top.onos.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Liu on 2016/11/18.
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    /*表单提交date数据类型转换*/
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//写上你要的日期格式
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {

        model.put("message", "Hello world");
        return "web";
    }

    @RequestMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student, Model model) {
//        student.setName("Liu");
//        model.addAttribute("student", student);
        return "studentForm";
    }

    @RequestMapping("/deleteStudent/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable int id) {
        boolean deleteResult = studentService.deleteStudent(id);
        if (deleteResult) {
            return "SUCCESS";
        } else {
            return "FAILURE";
        }
    }

    @RequestMapping("/saveStudent")
    public String save(@ModelAttribute Student student) {
        studentService.insertStudent(student);
        return "redirect:/students";
    }

    @RequestMapping("/students")
    public String login(Map<String, Object> model) {
        logger.info("INFO:This is a students list");
        logger.debug("DEBUG:This is a students list");
        List<Student> studentList = studentService.getAll();

        model.put("students", studentList);

        return "students";
    }

    @RequestMapping("/getData")
    @ResponseBody
    List<Student> getStudents() {
        List<Student> students = studentService.getAll();
        return  students;
    }

}
