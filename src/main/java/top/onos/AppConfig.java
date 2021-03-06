package top.onos;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Liu on 2016/11/18.
 */
/*注解声明为配置类*/
@Configuration
@EnableCaching
//@EnableAutoConfiguration
/*注解声明mapper自动扫描路径 和 <mybatis:scan/>同样效果 */
@MapperScan("top.onos.mapper")
public class AppConfig {


    /*注解注册数据源*/
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    /*注解注册SessionFactory*/
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }


    /*注释自定义CacheManager让Spring Boot按照依赖和顺序原则选择Cache Manager*/
/*    @Bean
    public CacheManager cacheManager() {
        MemcacheClientFactoryImpl memcacheClientFactory = new MemcacheClientFactoryImpl();
        AddressProvider addressProvider = new DefaultAddressProvider("192.168.78.129:11211,54.64.103.64:11211");
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setConsistentHashing(true);

        CacheFactory cacheFactory = new CacheFactory();
        cacheFactory.setCacheName("student");
        cacheFactory.setCacheClientFactory(memcacheClientFactory);
        cacheFactory.setAddressProvider(addressProvider);
        cacheFactory.setConfiguration(cacheConfiguration);

        Cache object = null;
        try {
            object = cacheFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SSMCache ssmCache = new SSMCache(object, 10000, true);

        ArrayList<SSMCache> ssmCaches = new ArrayList<SSMCache>();
        ssmCaches.add(0, ssmCache);

        SSMCacheManager ssmCacheManager = new SSMCacheManager();
        ssmCacheManager.setCaches(ssmCaches);

        return ssmCacheManager;
    }*/

 }
