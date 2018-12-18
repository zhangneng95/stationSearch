package indi.nengz.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


import javax.sql.DataSource;
import java.io.IOException;


@Configuration
@PropertySource({"classpath:indi/nengz/db.properties"})
public class DataSourceConfig {

//    @Autowired
//    Environment env;//还可以使用Environment获取properties信息
    //绑定资源属性
    @Value("${jdbc.driver}")
    String driver;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;


    @Bean
    public DataSource basicDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        basicDataSource.setUrl("jdbc:mysql://localhost:3306/search_station?serverTimezone=UTC  ");
//        basicDataSource.setUsername("root");
//        basicDataSource.setPassword("1234");
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setInitialSize(20);
        basicDataSource.setMaxWaitMillis(30);
        return basicDataSource;
    }

//        @Bean
//        public DataSourceTransactionManager transactionManager() throws IOException{
//            //这里的数据源要和配置SqlSessionFactoryBean中配置的数据源相同，事务才会生效
//            DataSourceTransactionManager transactionManager =
//                    new DataSourceTransactionManager(basicDataSource());
//            return transactionManager;
//    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(basicDataSource());
//    sqlSessionFactoryBean.setTypeAliasesPackage("com.amiu");
//    sqlSessionFactoryBean.setMapperLocations(
//            new PathMatchingResourcePatternResolver()
//              .getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

    //添加解析类才能让@PropertySource正确解析出${}中的值
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
