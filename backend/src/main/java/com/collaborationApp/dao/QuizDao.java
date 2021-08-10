package com.collaborationApp.dao;

import java.util.*;

import com.collaborationApp.model.Question;
import com.collaborationApp.model.Quiz;
/**
 * 
 * @author kabilsingh.balan
 *
 */
public interface QuizDao {
    void addQuiz(Quiz quiz);
    List<Quiz> getAllQuiz();
    Quiz getQuizByQuizName(String quizName);
    void addQuestion(Question question);
    
}
