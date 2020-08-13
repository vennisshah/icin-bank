package com.quiz.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.dao.QuizDAO;
import com.quiz.exception.BusinessException;
import com.quiz.model.Quiz;
import com.quiz.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	@Autowired
	private QuizDAO dao;

	@Override
	public Quiz addQuiz(Quiz quiz) throws BusinessException {

		if (isValidOpt(quiz.getQuestion())) {
			throw new BusinessException("Entered question " + quiz.getQuestion() + " is null. Please provide a value to it");
		}
		
		if (isValidOpt(quiz.getOpt1())) {
			throw new BusinessException("Entered option 1 " + quiz.getOpt1() + " is null. Please provide a value to it");
		}
		if (isValidOpt(quiz.getOpt2())) {
			throw new BusinessException("Entered option 2 " + quiz.getOpt2() + " is null. Please provide a value to it");
		}
		if (isValidOpt(quiz.getOpt3())) {
			throw new BusinessException("Entered option 3 " + quiz.getOpt3() + " is null. Please provide a value to it");
		}
		if (isValidOpt(quiz.getOpt4())) {
			throw new BusinessException("Entered option 4 " + quiz.getOpt4() + " is null. Please provide a value to it");
		}
		if (isValidOpt(quiz.getCorrect())) {
			throw new BusinessException("Entered correct answer " + quiz.getCorrect() + " is null. Please provide a value to it");
		}
		return dao.save(quiz);
	}

	@Override
	public Quiz getQuizById(int id) throws BusinessException {
		if(id<=0) {
			throw new BusinessException("Id "+id +" is invalid");
		}
		Quiz quiz=null;
		try {
			quiz=dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No quiz found for id "+id);
		}
		return quiz;
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) throws BusinessException {
		if (!isValidId(quiz.getId())) {
			throw new BusinessException("Entered id  " + quiz.getId() + " is invalid...cannot update");
		}
		return dao.save(quiz);
	}

	@Override
	public void deleteQuiz(int id) throws BusinessException {
		dao.deleteById(id);
		
	}

	@Override
	public List<Quiz> getAllQuiz() {
		
		return dao.findAll();
	}

	
	private boolean isValidOpt(String opt) {
		boolean b = false;
		if (opt.isEmpty()) {
			b = true;
		
		}
		return b;
	}
	private boolean isValidId(int id) {
		boolean b = false;
		if (id>0) {
			b = true;
		}
		return b;
	}
}
