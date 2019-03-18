package cn.itcast.springboot.javaconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@ComponentScan(basePackages="cn.itcast.springboot.javaconfig")
@PropertySource(value={"classpath:db.properties"})
public class SpringConfig {

	@Bean
	public UserDAO getUserDAO(){
		return new UserDAO();
	}
	
	@Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {//这里直接将方法名作为bean的id名字，一般不像getUserDao一样，定义成get开头，而是直接定义成小写开头的
    //且本来应该如同xml配置文件一样，返回BoneCPDataSource，该类是DataSource的子类，可直接返回
        //创建该数据库连接池对象，用来定义数据库连接池的属性
    	BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
        // 数据库驱动
        boneCPDataSource.setDriverClass(jdbcDriverClassName);
        // 相应驱动的jdbcUrl
        boneCPDataSource.setJdbcUrl(jdbcUrl);
        // 数据库的用户名
        boneCPDataSource.setUsername(jdbcUsername);
        // 数据库的密码
        boneCPDataSource.setPassword(jdbcUsername);
        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
        boneCPDataSource.setIdleMaxAgeInMinutes(30);
        // 每个分区最大的连接数
        boneCPDataSource.setMaxConnectionsPerPartition(100);
        // 每个分区最小的连接数    
        boneCPDataSource.setMinConnectionsPerPartition(5);
        return boneCPDataSource;//返回的不是DataSource，而直接是其子类：BoneCPDataSource
}

}
