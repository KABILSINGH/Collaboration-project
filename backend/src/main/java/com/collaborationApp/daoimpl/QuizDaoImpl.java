package com.collaborationApp.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborationApp.dao.QuizDao;
import com.collaborationApp.model.Question;
import com.collaborationApp.model.Quiz;
/**
 * 
 * @author kabilsingh.balan
 *
 */
@Repository
@Transactional
public class QuizDaoImpl implements QuizDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void addQuiz(Quiz quiz) {
		Session session=sessionFactory.getCurrentSession();
        session.save(quiz);
	}

	public void addQuestion(Question question) {
		Session session=sessionFactory.getCurrentSession();
        session.save(question);
	}

	public List<Quiz> getAllQuiz() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Quiz");
		return query.list();
	}

	public Quiz getQuizByQuizName(String quizName) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from quiz  where quizName=?");
		query.setString(0, quizName);	
		return (Quiz)query.uniqueResult();
	}

}
