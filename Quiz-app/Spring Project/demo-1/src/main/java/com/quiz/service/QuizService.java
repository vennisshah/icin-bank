package com.quiz.service;

import java.util.List;

import com.quiz.exception.BusinessException;
import com.quiz.model.Quiz;


public interface QuizService {
	public Quiz addQuiz(Quiz quiz) throws BusinessException ;
	public Quiz getQuizById(int id) throws BusinessException;
	public Quiz updateQuiz(Quiz quiz) throws BusinessException;
	public void deleteQuiz(int id) throws BusinessException;
	public List<Quiz> getAllQuiz();
}
