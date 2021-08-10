package com.collaborationApp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collaborationApp.dao.QuizDao;
import com.collaborationApp.dao.UserDao;
import com.collaborationApp.model.ErrorClazz;
import com.collaborationApp.model.Question;
import com.collaborationApp.model.Quiz;
import com.collaborationApp.model.User;
/**
 * 
 * @author kabilsingh.balan
 *
 */
@Controller
public class QuizController {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/addquiz", method=RequestMethod.POST)
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quizDetails,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		quizDetails.setPostedon(new Date());
		User postedBy=userDao.getUser(email);
		quizDetails.setPostedBy(postedBy);
		try
		{
			quizDao.addQuiz(quizDetails);
			return new ResponseEntity<Quiz>(quizDetails,HttpStatus.OK);
		}catch(Exception e)
		{
			ErrorClazz error=new ErrorClazz(6,"Unable to post blog..." +e.getMessage());
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@RequestMapping(value="/getAllQuesNames", method=RequestMethod.POST)
	public ResponseEntity<?> getQuestionName(HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(4,"UNAUTHORIZED ACCESS...");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		List<Quiz> quizz = quizDao.getAllQuiz();
		return new ResponseEntity<List<Quiz>>(quizz,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addQuestion", method=RequestMethod.POST)
	public ResponseEntity<?> addQuestion(@RequestBody Question questions,HttpSession session){
		System.out.println(questions.getAnswerType());
		System.out.println(questions.getCorrectAnswer());
		System.out.println(questions.getText());
		System.out.println(questions.getCorrectAnswer());
		if(questions.getAnswers() != null && !questions.getAnswers().isEmpty()){
			questions.getAnswers().forEach( s -> System.out.println(s));
		}
		return new ResponseEntity<Question>(questions,HttpStatus.OK);
	}
}
