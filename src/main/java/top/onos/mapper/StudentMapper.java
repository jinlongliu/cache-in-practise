package top.onos.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import top.onos.domain.Student;

import java.util.List;

/**
 * Created by Liu on 2016/11/18.
 */
@CacheConfig(cacheNames = "student")
public interface StudentMapper {

    @Cacheable(value = "student", key = "#p0")
    @Select("select id,name,address,birthday from student")
    List<Student> getAll(String cacheKey);

    @Insert("insert into student(name, address, birthday) values (#{name}, #{address}, #{birthday})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @CacheEvict(value = "student", allEntries = true)
    int insertStudent(Student student);

    @Delete("delete from student where id= #{id}")
    @CacheEvict(value = "student", allEntries = true)
    int deleteStudent(int id);
}
