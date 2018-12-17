package it.unical.asde2018.unitest.configuration;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("it.unical.asde2018.unitest.components.persistence"),
	    @ComponentScan("it.unical.asde2018.unitest.components.services") })
public class AppConfig {

	@Bean
	public DataSource getDataSource() {
		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		//dataSource.setUrl("jdbc:h2:mem:MyDB");
		dataSource.setUrl("jdbc:h2:file:~/git/Unitest/UniTest/data/db;DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory() {

		final LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getDataSource());
		lsfb.setHibernateProperties(getHibernateProperties());
		lsfb.setPackagesToScan("it.unical.asde2018.unitest.model");

		try {
			lsfb.afterPropertiesSet();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return lsfb.getObject();

	}

	private Properties getHibernateProperties() {

		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.show_sql", true);
		prop.put("hibernate.format_sql", true);
		prop.put("hibernate.hbm2ddl.auto", "update");
//		prop.put("hibernate.hbm2ddl.auto", "create");
		prop.put("hibernate.current_session_context_class", "thread");
		return prop;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory());
		return transactionManager;
	}

}
