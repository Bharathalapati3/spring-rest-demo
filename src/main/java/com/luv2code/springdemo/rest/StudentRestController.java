package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct 
	public void loadData() {

		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima","Patel"));
		theStudents.add(new Student("Bharath","A"));
		theStudents.add(new Student("Virat","Kohli"));
		
	}
	
	// define endpoint for /students - return list of Students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
		
	}
	
	//define endpoint for "/students/{studentId}
	
	@GetMapping("/students/{studentId}")
		
		public Student getStudent(@PathVariable int studentId) {
			
			//check the studentId against ListSize
		
		if((studentId>=theStudents.size()) || (studentId<0)) {
			
			throw new StudentNotFoundException("StudentId notFound:" +studentId);
		}
			return theStudents.get(studentId);
			
		}
	
	    //Add an Exception Handler
	
	   @ExceptionHandler
	   public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		  //create a Student ErrorResponse
		   
		   StudentErrorResponse error = new StudentErrorResponse();
		   
		   error.setStatus(HttpStatus.NOT_FOUND.value());
		   error.setMessage(exc.getMessage());
		   error.setTimeStsmp(System.currentTimeMillis());
		   
		   //return Response Entity
		   
		   return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler
	   public ResponseEntity<StudentErrorResponse> handleException(Exception  exc){
		  //create a Student ErrorResponse
		   
		   StudentErrorResponse error = new StudentErrorResponse();
		   
		   error.setStatus(HttpStatus.BAD_REQUEST.value());
		   error.setMessage(exc.getMessage());
		   error.setTimeStsmp(System.currentTimeMillis());
		   
		   //return Response Entity
		   
		   return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}


