package top.onos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import top.onos.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheInPractiseApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(CacheInPractiseApplication.class);

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private StudentService studentService;

	@Test
	public void contextLoads() {
		/*Student student = new Student();
		student.setName("LIU");
		studentService.insertStudent(student);

		studentService.getAll();*/
		/*测试应用采用的缓存管理器*/
		logger.info("=======================================================");
		logger.info(cacheManager.toString());
		logger.info("=======================================================");

	}

}
