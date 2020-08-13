package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.exception.BusinessException;
import com.quiz.model.Quiz;
import com.quiz.service.QuizService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {
	@Autowired
	private QuizService service;
	
	
	private MultiValueMap<String, String> map;
	
	@GetMapping("/quiz")
	public String sayWelcome() {
		return "Welcome to Quiz App \n";
	}
	@PostMapping("/quiz")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
		
		try {
			
			return new ResponseEntity<Quiz>(service.addQuiz(quiz),HttpStatus.OK);
			
		} catch (BusinessException e) {
			
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Quiz>(null,map, HttpStatus.NOT_ACCEPTABLE);
		}
	
	}
	
	@GetMapping("/quiz/{id}")
	public ResponseEntity<Quiz> getQuizById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Quiz>(service.getQuizById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Quiz>(null,map, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/quiz")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
		try {
			return new ResponseEntity<Quiz>(service.updateQuiz(quiz),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Quiz>(null,map, HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/quiz/{id}")
	public void deleteQuiz(@PathVariable("id") int id) throws BusinessException {
		
			service.deleteQuiz(id);

		
	}

	@GetMapping("/quizs")
	public List<Quiz> getAllQuiz() {
		
		return service.getAllQuiz();
	}




}
