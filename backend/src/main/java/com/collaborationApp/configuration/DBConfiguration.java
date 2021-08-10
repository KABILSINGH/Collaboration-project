package com.collaborationApp.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.collaborationApp.model.BlogComment;
import com.collaborationApp.model.BlogPost;
import com.collaborationApp.model.BlogPostLikes;
import com.collaborationApp.model.Friend;
import com.collaborationApp.model.Job;
import com.collaborationApp.model.Notification;
import com.collaborationApp.model.ProfilePicture;
import com.collaborationApp.model.Quiz;
import com.collaborationApp.model.User;
import com.collaborationApp.util.DBConstants;
import com.collaborationApp.util.PropertyReader;
/**
 * 
 * @author kabilsingh.balan
 *
 */
@Configuration
@EnableTransactionManagement
public class DBConfiguration {
  public DBConfiguration(){
	 System.out.println("DBConfiguration class is instantiated"); 
  }
  @Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf = new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(DBConstants.HIBERNATE_DIALECT , PropertyReader.getProperty(DBConstants.HIBERNATE_DIALECT));
		hibernateProperties.setProperty(DBConstants.HIBERNATE_HBM2DDL_AUTO, PropertyReader.getProperty(DBConstants.HIBERNATE_HBM2DDL_AUTO));
		hibernateProperties.setProperty(DBConstants.HIBERNATE_SHOW_SQL, PropertyReader.getProperty(DBConstants.HIBERNATE_SHOW_SQL));
		lsf.addProperties(hibernateProperties);
		Class classes[]=new Class[]{User.class,Job.class,BlogPost.class,Notification.class,BlogPostLikes.class,BlogComment.class,
				ProfilePicture.class,Friend.class,Quiz.class};/*class objects of all entities*/
    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(PropertyReader.getProperty(DBConstants.DRIVER_CLASS_NAME));
	    dataSource.setUrl(PropertyReader.getProperty(DBConstants.CONNECTION_URL));
	    dataSource.setUsername(PropertyReader.getProperty(DBConstants.USER_NAME));
	    dataSource.setPassword(PropertyReader.getProperty(DBConstants.PASSWORD));
	    return dataSource;
	  	}
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}
}


