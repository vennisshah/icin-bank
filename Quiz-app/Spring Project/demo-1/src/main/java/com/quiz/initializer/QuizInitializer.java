package com.quiz.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.quiz.dao.QuizDAO;
import com.quiz.model.Quiz;

@Component
public class QuizInitializer implements CommandLineRunner{
	@Autowired
	private QuizDAO quizdao;
	
	public QuizInitializer(QuizDAO quizdao) {
		
		
	}
	@Override
	public void run(String... args) throws Exception {
		this.quizdao.deleteAll();
		Quiz q1=new Quiz("(1) What is the default value of Object variable?","1. Undefined","2. 0","3. Null obj","4. None of the above","Null obj");
		Quiz q2=new Quiz("(2) What is the size of short variable?","1. 8-bit","2. 16-bit","3. 32-bit","4. 64-bit","16-bit");
		Quiz q3=new Quiz("(3) Which of the following is a thread safe?","1. StringBuffer","2. StringBuilder","3. Both","4. None","StringBuffer");
		Quiz q4=new Quiz("(4) java.util.Collections is a:","1. Interface","2. Class","3. Object","4. None of the above","Class");
		Quiz q5=new Quiz("(5) Which of those allows duplicate elements?","1. List","2. Set","3. All","4. None of the above","List");
		this.quizdao.save(q1);
		this.quizdao.save(q2);
		this.quizdao.save(q3);
		this.quizdao.save(q4);
		this.quizdao.save(q5);
		System.out.println("Database has been initialized");
	}

}
