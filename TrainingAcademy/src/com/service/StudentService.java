package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {

	Student getStudent(int studentId);
	
	Student getName(int studentId);

	List<Student> getAllStudent();

	int insertStudent(Student student);

	int deleteStudent(int studentId);

	int updateStudent(Student student);
	
	Student topFiveMeritListBatchWise(int batchId);
	
	Student topTenStudentOfAllBatch();
	
}
